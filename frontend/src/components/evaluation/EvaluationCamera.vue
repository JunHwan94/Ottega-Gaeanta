<template>
  <div class="main">
    <!-- <button id="toggleStream" @click="toggleStream()">Play</button><br>
    <button id="cvtGray" @click="cvtGray()" style="visibility: hidden;">Capture Image</button> -->
    <swal-alert></swal-alert>
    <video id="video" style="width: 90%; height: 100%; left: 52%;"></video>
    <img v-if="silhouette" id="guideLine" :src="silhouette" style="width : 35vw; height: 55vh; position: absolute; top: 33%; left: 34%;"/>
    <canvas id='output' style="width : 90%; height: 630px; display: none; left: 52%;"></canvas>
  </div>
</template>

<script>
  import SwalAlert from '@/components/SwalAlert'
  export default {
    name: 'EvaluationCamera',
    data: () => ({
      streaming: false,
      constraints: {
        video: { facingMode: "user", }, 
        audio: false
      },
      video: '',
      videoWidth: '',
      videoHeight: '',
      canvas: '',
      src: '',
      cap: '',
      file: '',
      formdata: '',
      stream: null,
      silhouette: ''
    }),
    components: {
      SwalAlert
    },
    methods: {
      toggleStream() {
        if (this.streaming === false) {
            navigator.getUserMedia(
              this.constraints, // user media config
              (stream) => { // success
                // this.$store.commit('SAVE_VIDEO_STREAM', stream)
                this.stream = stream
                this.video.width = this.videoWidth
                this.video.height = this.videoHeight//prevent Opencv.js error.
                video.srcObject = stream;
                video.play();

                this.silhouette = require('@/assets/silhouette.png')
                // setTimeout(this.cvtGray, 3000);
              },
              (error) => { // error
                console.log(error)
              }
            );
            // document.getElementById('toggleStream').innerHTML = "Stop";
            // document.getElementById('cvtGray').style.visibility = 'visible';
        }
        // else { // stop 버튼 누르면 화면 검은색 됨
        //     const stream = video.srcObject;
        //     alert('스탑누름')
        //     console.log(stream)
        //     console.log(stream.getTracks())
        //     const tracks = stream.getTracks();
        //     tracks.forEach(track => {
        //         track.stop();
        //     });
        //     document.getElementById('toggleStream').innerHTML = "Play";
        //     document.getElementById('cvtGray').style.visibility = 'hidden';
        // }
        this.streaming = !this.streaming;
      },
      cvtGray() {
        document.getElementById('guideLine').style.visibility = 'hidden';
        this.src = new cv.Mat(this.videoHeight, this.videoWidth, cv.CV_8UC4);;
        this.cap = new cv.VideoCapture('video'); 
        setTimeout(this.process, 30);
      },
      process() {
        if (this.streaming === true) {
            this.cap.read(this.src);
            this.video.style.display = 'none';
            document.querySelector('#output').style.display = ''
            cv.imshow('output', this.src);

            // this.canvas.toBlob((blob) => {
            //   let file = new File([blob], "fileName.jpg", { type: "image/jpg" })

            //   console.log('------------')
            //   console.log(file)
            //   console.log(blob)
            //   console.log(this)
            //   console.log(this.formdata)
            //   console.log('------------')
            //   let form = new FormData()
            //   form.append('image', file)
            //   // form.append('image', blob, 'test.jpg')
            //   console.log(form)
            //   this.$store.dispatch('evaluateImage', form)
            //     .then((result) => {
            //       alert('tst')
            //       alert(result.data);
            //     })
            // })

            const imgBase64 = this.canvas.toDataURL('image/jpeg', 'image/octet-stream')

            const decodImg = atob(imgBase64.split(',')[1]);

            let array = [];
            for (let i = 0; i < decodImg .length; i++) {
              array.push(decodImg .charCodeAt(i));
            }

            const file = new Blob([new Uint8Array(array)], {type: 'image/jpeg'});
            const fileName = 'canvas_img_' + new Date().getMilliseconds() + '.jpg';
            let formData = new FormData();
            formData.append('image', file, fileName);
            this.formdata = formData
            this.$store.commit('SAVE_USER_EVALUATION_IMAGE', URL.createObjectURL(file))

            // this.$store.dispatch('evaluateImage', formData)
            //     .then((result) => {
            //       alert('tst')
            //       alert(result.data);
            //       console.log(result.data)
            //     })



            // const imgDataUrl = this.canvas.toDataURL('image/jpg')
            // const blobBin = atob(imgDataUrl.split(',')[1]);	// base64 데이터 디코딩
            // let array = [];
            // for (let i = 0; i < blobBin.length; i++) {
            //     array.push(blobBin.charCodeAt(i));
            // }
            // const file = new Blob([new Uint8Array(array)], {type: 'image/jpg'});	// Blob 생성
            // console.log(file)
            // this.formdata = new FormData();	// formData 생성
            // this.formdata.append("image", file);	// file data 추가
        }
      },
      retryCamera(){
        this.video.style.display = '';
        document.getElementById('output').style.display = 'none'
        document.getElementById('guideLine').style.visibility = '';
      },
      post() {
        console.log(this.formdata)
        this.$store.dispatch('evaluateImage', this.formdata)
        .then((result) => {
          console.log(result);
          if(result.data == '' || result.data.top == null || result.data.pants == null) {
            console.log(result)
            this.$children[0].$vnode.componentInstance.swalAlert('error', '색상 추출이 불가합니다. <br>다시 시도해주세요.')
          } else {
            const getColorStyleReq = {
              top : result.data.top,
              bottom : result.data.pants
            }
            this.$store.commit('SAVE_USER_FASHION_RATE', result.data)

            this.$store.dispatch('getSimillarColorStyles', getColorStyleReq)
              .then((result) => {
                this.$store.commit('setEvalSameColorStyle', result.data.s3url)
                this.$children[0].$vnode.componentInstance.swalAlert('success', '드디어 의상 분석이 완료되었습니다.')
                  .then(() => {
                    this.$router.push('/evaluationResult')
                  })
              })
          }
        })
      }
    },
    mounted() {
      // video setting init
      const container = document.querySelector('.main')
      this.videoWidth = container.offsetWidth
      this.videoHeight = container.offsetHeight
      this.video = document.getElementById("video")
      this.canvas = document.getElementById('output')
      this.canvas.width = this.videoWidth;
      this.canvas.height = this.videoHeight
      console.log('마운트 됨요')
    },
    destroyed() {
      if (this.stream != null) { // 웹 캠 객체가 활성화 상태이면 비활성 처리함
        const tracks = this.stream.getTracks()
        tracks.forEach(track => {
          track.stop();
        });
      }
    }
  }
</script>

<style scoped>
video {
  width: 100%;
  height: 100%;
  padding: 10px;
}
.main {
  font-family: Cafe24Ssurround;
  width: 100%;
  height: 100%;
}
</style>
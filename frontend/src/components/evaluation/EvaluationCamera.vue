<template>
  <div class="main">
    <button id="toggleStream" @click="toggleStream()">Play</button><br>
    <button id="cvtGray" @click="cvtGray()" style="visibility: hidden;">Capture Image</button>
    <video id="video"></video>
    <canvas id='output' style="display: none;"></canvas>
  </div>
</template>

<script>
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
    }),
    methods: {
      toggleStream() {
        if (this.streaming === false) {
            navigator.getUserMedia(
              this.constraints, // user media config
              (stream) => { // success
                this.video.width = this.videoWidth
                this.video.height = this.videoHeight //prevent Opencv.js error.
                video.srcObject = stream;
                video.play();
                setTimeout(this.cvtGray, 3000);
              },
              (error) => { // error
                console.log(error)
              }
            );
            document.getElementById('toggleStream').innerHTML = "Stop";
            document.getElementById('cvtGray').style.visibility = 'visible';
        }
        else { // stop 버튼 누르면 화면 검은색 됨
            const stream = video.srcObject;
            const tracks = stream.getTracks();
            tracks.forEach(track => {
                track.stop();
            });
            document.getElementById('toggleStream').innerHTML = "Play";
            document.getElementById('cvtGray').style.visibility = 'hidden';
        }
        this.streaming = !this.streaming;
      },
      cvtGray() {
        this.src = new cv.Mat(this.videoHeight, this.videoWidth, cv.CV_8UC4);
        this.cap = new cv.VideoCapture('video');
        setTimeout(this.process, 30);
      },
      process() {
        if (this.streaming === true) {
            this.cap.read(this.src);
            this.video.style.display = 'none';
            document.querySelector('#output').style.display = 'block';
            cv.imshow('output', this.src);

            const imgDataUrl = this.canvas.toDataURL('image/jpg')
            const blobBin = atob(imgDataUrl.split(',')[1]);	// base64 데이터 디코딩
            let array = [];
            for (let i = 0; i < blobBin.length; i++) {
                array.push(blobBin.charCodeAt(i));
            }
            const file = new Blob([new Uint8Array(array)], {type: 'image/jpg'});	// Blob 생성
            // console.log(file);
            this.formdata = new FormData();	// formData 생성
            this.formdata.append("image", file);	// file data 추가

            // this.formdata = formdata;
            console.log(this.formdata);
            // this.file = file
        }
      },
      post() {
        this.$store.dispatch('evaluateImage', this.formdata)
        .then((result) => {
          console.log(result.data);
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
    }
  }
</script>

<style scoped>
video {
  width: 100%;
  height: 100%;
}
.main {
  font-family: Cafe24Ssurround;
  width: 100%;
  height: 100%;
}
</style>
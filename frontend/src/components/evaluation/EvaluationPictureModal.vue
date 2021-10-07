<template>
  <div class="modal-container">
    <swal-alert></swal-alert>
    <span style="font-size: 3vh;">사진으로 의상 색 조합 평가</span>
    <span style="float: right; cursor: pointer;" @click="close()">X</span>
    <div class="divider"></div>
    <div v-if="!imageObject" class="file-frame margin-auto" id="unSelectFileFrame"
      @drop.prevent="dropInputTag($event)" 
      @dragenter="dragEnter()" 
      @dragleave="dragLeave()" 
      @dragover.prevent>
      <div align="center">파일을 끌어서 올려주세요</div>
    </div>
    <div v-else class="margin-auto file-mounted"
      @drop.prevent="dropInputTag($event)"
      @dragover.prevent>
      <div style="margin-top:10px;" align="center">
        <img :src="imageObject" alt="image" class="present-image"><br>
        <div align="center">{{ image.name }}</div>
        <!-- <div align="center">{{ fileSizeFilter }}</div> -->
      </div>
    </div>
    <div class="mt-5">
      <span>파일 용량</span>
      <div class="divider"></div>
      <div align="center">
        <span v-if="image">{{ fileSizeFilter(image.size) }}</span>
      </div>
    </div>
    <div>
    <div class="btn-area" align="center">
      <div class="confirm-btn" @click="analyzeImage()">
        분석하기
      </div>
      <div class="cancel-btn" @click="close()">
        취소
      </div>
    </div>
    </div>
  </div>
</template>

<script>
  import SwalAlert from '@/components/SwalAlert'
  export default {
    name: 'EvaluationPictureModal',
    data: () => ({
      image: null,
      imageObject: null,
    }),
    components: {
      SwalAlert
    },
    methods: {
      close() {
        this.$emit('close')
      },
      dropInputTag(event) {
        console.log('영역안에 파일이 지정됨')
        const file = Array.from(event.dataTransfer.files, v => v)[0]
        // 파일이 jpg, png가 아니면 다른 파일 객체에
        const extension = file.name.split('.')[1] // 파일 full name

        const imageExtension = ['jpg', 'JPG', 'jpeg', 'JPEG', 'png', 'PNG']
        if (imageExtension.includes(extension)) {
          this.imageObject = URL.createObjectURL(file)
          this.$store.commit('SAVE_USER_EVALUATION_IMAGE', this.imageObject)
        } else {
          this.$children[0].$vnode.componentInstance.swalAlert('error', '사진 파일을 업로드 해주세요.')
          return
        }
        this.image = file
      },
      dragEnter() {
        const frame = document.getElementById('unSelectFileFrame')
        // frame.style.borderColor = 'green'
        // file-mounted
        // frame.className = 'file-mounted'
        frame.classList.add('file-mounted', 'margin-auto')
      },
      dragLeave() {
        const frame = document.getElementById('unSelectFileFrame')
        frame.classList.remove('file-mounted')
        frame.classList.add('file-frame')
        // frame.style.borderColor = 'gray'
      },
      fileSizeFilter(size) {
        let convertedFileSize = ''
        if (size / 1000000 >= 1) {
          convertedFileSize = (size / 1000000).toFixed(2) + 'MB'
        } else if (size / 1000 >= 1) {
          convertedFileSize = (size / 1000).toFixed(2) + 'KB'
        } else {
          convertedFileSize = size + 'B'
        }
        return convertedFileSize
      },
      analyzeImage () {
        if (this.image) {
          const form = new FormData()
          form.append('image', this.image)
          this.$store.dispatch('evaluateImage', form)
          .then((result) => {
            if(result.data == '' || result.data.top == null || result.data.pants == null) {
              console.log(result)
              this.$children[0].$vnode.componentInstance.swalAlert('error', '색상 추출이 불가합니다. <br>다시 시도해주세요.')
            } else {
              console.log(result.data)
              const getColorStyleReq = {
                top : result.data.top,
                bottom : result.data.pants
              }
              this.$store.commit('SAVE_USER_FASHION_RATE', result.data)

              this.$store.dispatch('getSimillarColorStyles', getColorStyleReq)
                .then((result) => {
                  console.log(result.data)
                  this.$store.commit('setEvalSameColorStyle', result.data.s3url)
                  this.$children[0].$vnode.componentInstance.swalAlert('success', '드디어 의상 분석이 완료되었습니다.')
                    .then(() => {
                      this.$router.push('/evaluationResult')
                    })
                })
            }
          })
        }
      }
    },
  }
</script>

<style scoped>
.modal-container {
  width: 40vw;
  height: 60vh;
  background-color: #F4F9F9;
  border-radius: 10px;
  position: absolute;
  top: 20%;
  left: 30%;
  border: 2px solid #F875AA;
  padding: 15px;
  font-family: Cafe24Ssurround; /* Binggrae-Bold */
}
.divider {
  height: 2px;
  width: 100%;
  background-color:  #FBACCC;
}
.file-frame {
  width: 90%;
  height: 50%;
  border: 2px dashed gray;
  margin-top: 20px;
  border-radius: 20px;
}
.margin-auto {
  margin-left: auto;
  margin-right: auto;
}
#unSelectFileFrame {
  line-height: 25vh;
}
.present-image {
  width: 20vh;
  height: 20vh;
}
.file-mounted {
  width: 90%;
  height: 50%;
  border: 2px dashed transparent;
  margin-top: 20px;
  border-radius: 25px;
  animation: changeColor 1.8s infinite linear
}
@keyframes changeColor {
  0% {
    border-color: rgb(255, 10, 10);
  }

  20% {
    border-color: rgb(185, 77, 86);
  }

  40% {
    border-color: rgb(226, 115, 130);
  }

  60% {
    border-color: rgb(221, 18, 137);
  }

  80% {
    border-color: rgb(240, 95, 167);
  }

  100% {
    border-color: rgb(22, 17, 97);
  }
}
.cancel-btn {
  width: 10vw;
  height: 70px;
  line-height: 70px;
  background-color: #F4F9F9;
  border: 2px solid #F875AA;
  color: #F875AA;
  display: inline-block;
  border-radius: 10px;
  margin: 0px 10px;
  cursor: pointer;
}
.confirm-btn {
  width: 10vw;
  height: 70px;
  line-height: 70px;
  background-color: #F4F9F9;
  border: 2px solid #F875AA;
  display: inline-block;
  border-radius: 10px;
  margin: 0px 10px;
  color: #F875AA;
  cursor: pointer;
}
.cancel-btn:hover {
  color: #F4F9F9;
  background-color: #F875AA; 
}
.confirm-btn:hover {
  color: #F4F9F9;
  background-color: #F875AA; 
}
.btn-area {
  margin-top: 50px;
}
</style>
<template>
  <div class="modal-container">
    <span style="font-size: 3vh;">스타일 평가 기준</span>
    <span style="float: right; cursor: pointer;" @click="close()">X</span>
    <div class="divider"></div>
    <div align="center" class="mt-4">
      <span style="font-size: 2.2vh;">상하의에 대한&nbsp;</span>
      <span style="font-size: 2.2vh; color: #F875AA;">13가지</span>
      <span style="font-size: 2.2vh;">의&nbsp;</span>
      <span style="font-size: 2.2vh; color: #F875AA;">색의 조합</span>
      <span style="font-size: 2.2vh;">을 바탕으로 등급을 책정합니다</span>
    </div>
    <div align="center">
      <img id="evaluationExampleImg" :src="evaluationExample" alt="평가기준">
    </div>
    <div align="center" class="mt-4">
      <span style="font-size: 2.2vh;">( 상의 13개의 색 )  x  ( 하의 13개의 색 ) = 총&nbsp;</span>
      <span style="font-size: 2.2vh; color: #F875AA;">169개의 조합이</span>
    </div>
    <div align="center">
      <span style="font-size: 2.2vh; color: #F875AA;">A ~ F&nbsp;</span>
      <span style="font-size: 2.2vh;">의&nbsp;</span>
      <span style="font-size: 2.2vh; color: #F875AA;">5개 등급</span>
      <span style="font-size: 2.2vh;">으로 책정됩니다</span>
    </div>
    <br><br>
    <div align="center" class="mt-5">
      <img id="evaluationExampleImg" :src="evaluationExample2" alt="평가기준">
    </div>
    <div align="center" class="mt-5">
      <span style="font-size: 2.2vh; color: #F875AA;">웹캠&nbsp;</span>
      <span style="font-size: 2.2vh;">또는&nbsp;</span>
      <span style="font-size: 2.2vh; color: #F875AA;">이미지 파일</span>
      <span style="font-size: 2.2vh;">로 업로드된 착장샷이&nbsp;</span>
    </div>
    <div align="center" class="">
      <span style="font-size: 2.2vh;">색을 추출하는 &nbsp;</span>
      <!-- <span style="font-size: 2.2vh; color: #F875AA;">딥러닝 모델</span> -->
      <span style="font-size: 2.2vh;">과정을 거쳐 등급화됩니다 &nbsp;</span>
    </div>
    <br>
    <div class="divider"></div>
    <div align="right" class="mt-3">
      <div align="center" class="cancel-btn" @click="close()">
        닫기
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    close() {
      this.$emit('close')
    },
  },
  computed: {
    evaluationExample () {
      return require('@/assets/evaluation_example2.png')
    },
    evaluationExample2 () {
      return require('@/assets/evaluation_example4.png')
    }
  }
}
</script>

<style>
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
  overflow:scroll;
  font-family: Cafe24Ssurround; /* Binggrae-Bold */
}
.modal-container::-webkit-scrollbar {
  width: 10px;
}
.modal-container::-webkit-scrollbar-thumb {
  background-color: #F875AA;
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}
.modal-container::-webkit-scrollbar-track {
  background-color: F4F9F9;
  border-radius: 10px;
  box-shadow: inset 0px 0px 5px white;
}
.divider {
  height: 2px;
  width: 100%;
  background-color:  #FBACCC;
}
#evaluationExampleImg {
  width: 30vw;
  margin-top: 2vh;
  
}
.cancel-btn {
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
</style>
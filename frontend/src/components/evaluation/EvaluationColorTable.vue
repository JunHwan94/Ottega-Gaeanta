<template>
  <div class="modal-container">
    <span style="font-size: 3vh;">색 조합표</span>
    <span style="float: right; cursor: pointer;" @click="close()">X</span>
    <hr>
    <div class="cancel-btn" @click="close()">
      닫기
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
  font-family: Cafe24Ssurround; /* Binggrae-Bold */
}
</style>
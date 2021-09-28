<template>
  <div>
    <!-- <div class="changeStyle">
      <v-img :src="changeStyleImg" class="vimg"></v-img>
      <div style="font-family: Binggrae-Bold;" class="vbtn">
        선호스타일
      </div>
    </div> -->
  </div>
</template>

<script>
export default {
  name: 'ChangeStyleModal',
  data () {
    return {
      changeStyleImg: require('@/assets/changestylelogo.png')
    }
  }
}
</script>

<style>
.changeStyle {
  color: #F875AA;
  cursor: pointer;
  margin-left: 60px;
}
.vimg {
  width: 40px;
  height: 40px;
}
.vbtn {
  margin-top: 5px;
}
</style>
<template>
  <div class="main">
    <img class="main-image" :src="mainImageUrl"/>
    <div class="main-title text">
      어? 너<br>
      옷태가 괜찮다?
    </div>
    <div class="main-text text">
      패션 피플이 선택한 AI 의류 추천 서비스<br>
      120만 건이 의류 조합을 한 번에!
    </div>
  </div>
</template>

<script>
  export default {
    name: 'LandingMain',
    data: () => ({
      mainImageUrl: 'https://www.10wallpaper.com/wallpaper/1366x768/1611/Girl_in_white_dress-Celebrity_Poster_Wallpapers_1366x768.jpg',
    }),
  }
</script>

<style scoped>
.main {
  text-align: center;
  position: relative;
}
.main-image {
  width: 90%;
  height: 93vh;
}
.text {
  font-weight: bold;
  color: white;
  width: 100%;
}
.main-title {
  left: 150px;
  top: 100px;
  font-size: 4rem;
  position: absolute;
  text-align: initial;
}
.main-text {
  left: 150px;
  top: 600px;
  font-size: 2rem;
  position: absolute;
  text-align: initial;
}
</style>
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
      mainImageUrl: require('@/assets/main.png'),
    }),
  }
</script>

<style scoped>
.main {
  text-align: center;
  margin-top: 4rem;
}
.main-image {
  width: 90%;
  height: 93vh;
}
.main-title {
  left: 150px;
  top: 100px;
  font-size: 4rem;
  position: absolute;
  text-align: initial;
  font-family: Binggrae-Bold;
  animation: fadeIn 1.5s ease-in-out;
}
.text {
  font-weight: bold;
  color: black;
  width: 100%;
  font-family: Binggrae-Bold;
  animation: fadeIn 2.0s ease-in-out;
}
.main-text {
  left: 150px;
  top: 600px;
  font-size: 2rem;
  position: absolute;
  text-align: initial;
}
@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(-50px);
  }
  to {
    opacity: 3;
    transform: none;
  }
}
</style>
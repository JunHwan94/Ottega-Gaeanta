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
      // mainImageUrl: 'https://post-phinf.pstatic.net/MjAyMTA0MDZfMjIw/MDAxNjE3Njk0NTYzMDIy.vh_iFhI2K6VWGCSX0ysqFr23aPnYqPTZkzpbUav7xRkg.AWMAI1T96OnWsGWPDDwHrkNCAgOlBho_S9cqzhArFg8g.JPEG/%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8_%EB%8F%84%EC%8B%9D%ED%99%94.jpg?type=w1200',
      mainImageUrl: require('@/assets/main.png'),
    }),
  }
</script>

<style scoped>
@font-face {
    font-family: 'Binggrae-Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/Binggrae-Bold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
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
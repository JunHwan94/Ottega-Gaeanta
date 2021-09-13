<template>
  <div class="slider">
    <div>
      <v-container class="lighten-5">
        <v-row class="mb-12" no-gutters>
          <v-col lg="3">
            스마트 검색
          </v-col>
          <v-col lg="3">
            코디 추천
          </v-col>
          <v-col lg="3">
            퍼스널 컬러
          </v-col>
          <v-col lg="3">
            코디 점수
          </v-col>
        </v-row>
      </v-container>
      <v-container class="lighten-5">
        <v-row class="mb-6" justify="center" no-gutters>
          <v-col lg="4">
            <img :src="image" />
          </v-col>
          <v-col lg="4">
            안녕하세요
          </v-col>
        </v-row>
      </v-container>
      <div class="progressContainer">
        <div class="progress" @click="nextPage"/>
        <div class="progress" @click="nextPage"/>
        <div class="progress" @click="nextPage"/>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    name: 'LandingSlider',
    components: {},
    data: () => ({
      image: 'https://img1.daumcdn.net/thumb/R1280x0.fpng/?fname=http://t1.daumcdn.net/brunch/service/user/6x6e/image/mG_H5qGH5RElp6kLQGHG0sheyG8.png',
      page: 1,
    }),
    methods: {
      nextPage() {
        this.page += 1
        alert(this.page)
      }
    }
  }
</script>

<style scoped>
.slider {
  width: 80%;
  margin-left: 10%;
  height: 45vh;
  text-align: center;
}
@font-face {
    font-family: 'HSYuji-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/HSYuji-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
div {
  font-family: 'HSYuji-Regular';
  color: hotpink;
}
img {
  width:25vw;
}
.progressContainer {
  text-align: center;
}
.progress {
  display: inline-block;
  width: 10px;
  height: 10px;
  border-radius: 10px;
  background: rgb(194, 191, 191);
  margin: 10px 10px;
  cursor: pointer;
}
.progress:hover {
  box-shadow: 0 0 5px #FF0000;
}
</style>
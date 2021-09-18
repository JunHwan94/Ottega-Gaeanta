<template>
  <div class="film-container" align="center">
    <div class="title">
      <h2>보이는 예시화면과 같이 정면을 향하여<br>상의 및 하의가 잘 보일 수 있도록 해주세용~♥</h2>
    </div>
    <v-row class="menu-container" justify="center">
      <v-col lg=3></v-col>
      <v-col lg=3 align="right">
        <div class="card" align="center">
          <p>아래 예시와 같이 화면에 상의 및 하의가</p>
          <img :src="mainImageUrl" />
        </div>
      </v-col>
      <v-col lg=3 align="left">
        <div class="card" align="center">
          <img :src="mainImageUrl" />
        </div>
      </v-col>
      <v-col lg=3></v-col>
    </v-row>
    <v-row justify="center">
      <div class="capture-btn" @click="capture()">
        <h2>5초 뒤 촬용😊</h2>
      </div>
    </v-row>
  </div>
</template>

<script>
  export default {
    data: () => ({
      mainImageUrl: require('@/assets/evaluation-model.png'),
    }),
    methods: {
      capture() {
        alert('test')
      }
    },
  }
</script>

<style scoped>
.film-container {
  padding-top: 4rem;
  height: 100%;
  width: 100vw;
  background: linear-gradient(#8AFFC7 5%, #FFCECE, #BAD7DF);
}
.title {
  margin-top: 10vh;
  margin-bottom: 5vh;
}

.content-area {
  width: 100%;
  height: 70%;
}
img {
  width: 200px;
  height: 200px;
}
.card {
  display: inline-block;
  width: 300px;
  height: 300px;
  border: 3px solid black;
  border-radius: 5%;
  margin: 15px 15px;
  padding: 10px 0px;
}
p, h2 {
  font-family: HSYuji-Regular;
}
.capture-btn {
  border: 2px solid black;
  padding: 10px;
  width: 25vw;
  border-radius: 25px;
  background-color: violet;
  cursor: pointer;
}
</style>
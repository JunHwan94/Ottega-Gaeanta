<template>
  <div class="eval-container">
    <v-container>
      <v-row class="mb-12 intro" justify="center" no-gutters>
        상의, 하의, 원피스 이미지를 업로드하시면 가상으로 스타일링해드립니다.
      </v-row>
    </v-container>
    <div class="card">
      <v-row class="menu-container" justify="center">
        <v-col lg=4>
          <img class="left-image" style="width:400px; height:400px; visibility: hidden;" />
        </v-col>
        <v-col lg=4>
          <v-row class="menu-container" justify="center" @click="changePage(0)">
            <div class="menu">
              실시간 측정 방식
              <v-icon large color="white darken-5">mdi-selection</v-icon>
            </div>
          </v-row><br>
          <v-row class="menu-container" justify="center">
            <div class="menu">
              사진 업로드 방식
              <v-icon large color="white darken-5"> mdi-folder-star</v-icon>
            </div>
          </v-row><br>
          <v-row class="menu-container" justify="center">
            <div class="menu">
              색 조합표 보기
              <v-icon large color="white darken-5"> mdi-arrow-up-bold-box-outline</v-icon>
            </div>
          </v-row>
        </v-col>
        <v-col lg=4>
          <img class="right-image" style="width:400px; height:400px; visibility: hidden;" />
        </v-col>
      </v-row>
    </div>
  </div>
</template>

<script>
  export default {
    data: () => ({
      pages: ['evaluationFilm'],
      mainImageUrl: '',
    }),
    mounted() {
      const menu = document.querySelectorAll('.menu')
      const leftImage = document.querySelector('.left-image')
      const rightImage = document.querySelector('.right-image')
      menu[0].addEventListener('mouseover', function () {
        imageClear()
        leftImage.src = require('@/assets/main.png')
        leftImage.style.visibility = 'visible'
      })
      menu[1].addEventListener('mouseover', function () {
        imageClear()
        rightImage.src = require('@/assets/main.png')
        rightImage.style.visibility = 'visible'
      })
      menu[2].addEventListener('mouseover', function () {
        imageClear()
        leftImage.src = require('@/assets/main.png')
        leftImage.style.visibility = 'visible'
      })

      const imageClear = function () {
        leftImage.style.visibility = 'hidden'
        rightImage.style.visibility = 'hidden'
      }
    },
    methods: {
      changePage(index) {
        this.$router.push(this.pages[index])
      },
    }
  }
</script>

<style scoped>
.eval-container {
  padding-top: 4rem;
  height: 100vh;
  width: 100vw;
  background: linear-gradient(to bottom right, skyblue, white);
}

.intro {
  font-family: HSYuji-Regular;
}

.card {
  width: 80vw;
  height: 60vh;
  background-color: rgb(255, 255, 255);
  border: 1px solid white;
  border-radius: 10px;
  margin: 0 auto;
  /* opacity: 0.6; */
  padding: 50px;
}

.menu-container {
  height: 10vh;
  margin-top: 3vh;
  font-size: 1.2rem;
}

.menu {
  width: 20vw;
  height: 10vh;
  border: 1px solid hotpink;
  text-align: center;
  line-height: 10vh;
  /* margin-top: 2rem; */
  object-fit: cover;
  /* filter: grayscale(100%) contrast(120%); */
  box-shadow: 10px 15px 25px 0 rgba(0, 0, 0, .2);
  /* display: block; */
  transition: all .5s cubic-bezier(0.645, 0.045, 0.355, 1);
  margin-top: -10px;
  background-color: hotpink;
  border-radius: 8px;
  cursor: pointer;
  font-family: HSYuji-Regular;
  ;
  /* margin-bottom: 20px; */
}

.menu:hover {
  box-shadow: 1px 1px 10px 0 rgba(0, 0, 0, .1);
  margin-top: 0;
}
</style>
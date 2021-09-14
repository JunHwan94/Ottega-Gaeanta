<template>
  <div class="slider">
    <div>
      <v-container class="lighten-5">
        <v-row class="mb-12" no-gutters>
          <v-col class="menu" lg="3" @click="nextPage(1)">
            스마트 검색
          </v-col>
          <v-col class="menu" lg="3" @click="nextPage(2)">
            코디 추천
          </v-col>
          <v-col class="menu" lg="3" @click="nextPage(3)">
            퍼스널 컬러
          </v-col>
          <v-col class="menu" lg="3" @click="nextPage(4)">
            코디 점수
          </v-col>
        </v-row>
      </v-container>
      <v-container class="lighten-5">
        <!-- 똑똑하게 검색하기 소개 -->
        <v-row class="mb-6 menu-row" justify="center" no-gutters v-show="page === 1">
          <v-col lg="4">
            <img :src="image[0]" />
          </v-col>
          <v-col lg="1"></v-col>
          <v-col class="menu-detail" lg="4">
            <div class="menu-detail-title">똑똑하게 검색하기</div>
            <div class="menu-detail-content">
              오늘 입고나갈 옷👚은 정하셨나요?<br>
              다른 사람들은 어떻게 옷을 입는지 구경하고<br>
              나만의 스타일을 만들어가세요.
            </div>
            <div class="menu-btn" :style="{ backgroundColor: btnColor[page - 1]}">
              스타일 똑똑하게 검색하세요!
            </div>
          </v-col>
        </v-row>

        <!-- 빅데이터로 정확하게 소개 -->
        <v-row class="mb-6 menu-row" justify="center" no-gutters v-show="page === 2">
          <v-col lg="4">
            <img :src="image[1]" />
          </v-col>
          <v-col lg="1"></v-col>
          <v-col class="menu-detail" lg="4">
            <div class="menu-detail-title">빅데이터로 정확하게!</div>
            <div class="menu-detail-content">
              120만건의 패션 스타일을 분석하여<br>
              어울리는 스타일과 색상을 알려드려요!
            </div>
            <div class="menu-btn" :style="{ backgroundColor: btnColor[page - 1]}">
              나만의 코디를 추천 받고싶다면?
            </div>
          </v-col>
        </v-row>

        <!-- 퍼스널 컬러 기능 소개 -->
        <v-row class="mb-6 menu-row" justify="center" no-gutters v-show="page === 3">
          <v-col lg="4">
            <img :src="image[2]" />
          </v-col>
          <v-col lg="1"></v-col>
          <v-col class="menu-detail" lg="4">
            <div class="menu-detail-title">내 피부에 날개를 달아줘</div>
            <div class="menu-detail-content">
              나의 피부톤을 정확하게 알고 자신만의<br>
              개성있는 스타일을 만들어가세요!
            </div>
            <div class="menu-btn" :style="{ backgroundColor: btnColor[page - 1]}">
              나이 퍼스널 컬러 알아보기
            </div>
          </v-col>
        </v-row>

        <!-- 서비스 시작하기 -->
        <v-row class="mb-6 menu-row" justify="center" no-gutters v-show="page === 4">
          <v-col lg="4">
            <img :src="image[3]" />
          </v-col>
          <v-col lg="1"></v-col>
          <v-col class="menu-detail" lg="4">
            <div class="menu-detail-title">지금 바로 둘러보기</div>
            <div class="menu-detail-content">
              지금 바로 옷태가 괜찮네 서비스에<br>
              접속하고 다양한 기능을 경험하세요.
            </div>
            <div class="menu-btn" :style="{ backgroundColor: btnColor[page - 1]}">
              서비스 시작하기
            </div>
          </v-col>
        </v-row>
      </v-container>
      <div class="progress-container">
        <div class="progress" @click="nextPage(1)"/>
        <div class="progress" @click="nextPage(2)"/>
        <div class="progress" @click="nextPage(3)"/>
        <div class="progress" @click="nextPage(4)"/>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    name: 'LandingSlider',
    components: {},
    data: () => ({
      image: [
        'https://img1.daumcdn.net/thumb/R1280x0.fpng/?fname=http://t1.daumcdn.net/brunch/service/user/6x6e/image/mG_H5qGH5RElp6kLQGHG0sheyG8.png',
        'https://static.coupangcdn.com/image/vendor_inventory/5fdd/3635f2d30ae5299adad49ac0d61cc2cf47a02d5c1f70d3e37db5f9ed1d54.jpg',
        'https://lh3.googleusercontent.com/proxy/LLxe4nMUgm83UjeZrDOMpsdVNPCA-X6sjcX113hVN5tgrymZ8rfOcpYtU17Dm9sX-tZk_8mi4SUIcCZWTNjfxwGqVxe-Wwnb9TE8PjeaGGJzJNLzoublBTb4Hr5fNYvwJgNeRBtagdBpMugfXpwTa466Jj6pqI_mjvDcv2b23WiWkvrMH64',
        'https://post-phinf.pstatic.net/MjAyMTA0MDZfMjIw/MDAxNjE3Njk0NTYzMDIy.vh_iFhI2K6VWGCSX0ysqFr23aPnYqPTZkzpbUav7xRkg.AWMAI1T96OnWsGWPDDwHrkNCAgOlBho_S9cqzhArFg8g.JPEG/%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8_%EB%8F%84%EC%8B%9D%ED%99%94.jpg?type=w1200'
      ],
      btnColor: [
        '#BAD7DF',
        '#FFE2E2',
        '#99DDCC',
        'hotpink',
      ],
      page: 1,
    }),
    methods: {
      nextPage(page) {
        this.page = page
        this.moveFocusing(page)
      },
      clearFocusing() {
        const menu = document.getElementsByClassName('menu')
        const progress = document.getElementsByClassName('progress')
        for (let i = 0; i < menu.length; i++) {
          menu[i].style.color = 'hotpink' // <- menu hover 문제
          // menu[i].classList.remove('menu')
          progress[i].style.background = 'white'
          progress[i].style.borderColor = '#e4d2d2';
        }
      },
      moveFocusing(index) {
        this.clearFocusing()
        const menu = document.querySelector(`.menu:nth-child(${index})`)
        const progress = document.querySelector(`.progress:nth-child(${index})`)
        menu.style.color = 'red'
        progress.style.background = this.btnColor[index - 1]
        progress.style.borderColor = this.btnColor[index - 1]
      },
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
@font-face {
    font-family: 'Cafe24Ssurround';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/Cafe24Ssurround.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
img {
  width:25vw;
  height: 250px;
}
.progress-container {
  text-align: center;
}
.progress {
  display: inline-block;
  width: 10px;
  height: 10px;
  border-radius: 10px;
  background: white;
  border: 2px solid #e4d2d2;
  margin: 5px 5px;
  cursor: pointer;
}
.progress:hover {
  box-shadow: 0 0 5px green;
}
.menu {
  font-family: 'HSYuji-Regular';
  font-size: 1.5rem;
  color: hotpink;
  cursor: pointer;
}
.menu:hover {
  color: red;
}
.menu-detail {
  font-family: Cafe24Ssurround;
  text-align: left;
}
.menu-detail-title {
  font-size: 2rem;
}
.menu-detail-content {
  margin-top: 1.5rem;
  font-size: 1.2rem;
}
.menu-btn {
  text-align: center;
  margin-top: 3rem;
  border-radius: 20px;
  padding: 10px;
  cursor: pointer;
}
.menu-row {
  animation: fadeIn 1.0s ease-in-out;
}
@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateX(50px);
  }
  to {
    opacity: 3;
    transform: none;
  }
}
</style>
<template>
  <div class="slider">
    <Snowf :amount="20" :size="5" :speed="1.5" :wind="10" :opacity="1" :swing="1" :image="null" :zIndex="1"
      :resize="true" color="#ff69b4" />
    <div>
      <br>
      <v-container class="lighten-5">
        <v-row class="mb-12" no-gutters>
          <v-col class="menu" lg="4" @click="nextPage(1)" align="right" style="padding-right: 150px;">
            스타일 검색
          </v-col>
          <v-col class="menu" lg="4" @click="nextPage(2)">
            의상 색 조합 분석
          </v-col>
          <v-col class="menu" lg="4" @click="nextPage(3)" align="left" style="padding-left: 150px;">
            패피티아이
          </v-col>
          <!-- <v-col class="menu" lg="3" @click="nextPage(4)">
            코디 점수
          </v-col> -->
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
            <div class="menu-btn" @click="changePage(0)">
              스타일 똑똑하게 검색하기
            </div>
          </v-col>
        </v-row>

        <!-- 빅데이터로 정확하게 소개 -->
        <v-row class="mb-6 menu-row" justify="center" no-gutters v-show="page === 2">
          <v-col lg="4">
            <img :src="image[1]"  style="width: 20vw;"/>
          </v-col>
          <v-col lg="1"></v-col>
          <v-col class="menu-detail" lg="4">
            <div class="menu-detail-title">내 의상 색 조합은 괜찮을까?</div>
            <div class="menu-detail-content" style="font-weight:normal;">
              미디어 장치, 사진을 활용해 옷의 <br>
              <span style="color: #f875aa;">색 조합</span>을 분석해드립니다! 그리고 <br>
              추천을 통해 자신만의 색상 조합을 알아보세요!
            </div>
            <div class="menu-btn" @click="changePage(1)">
              내 의상을 분석하고 싶다면?
            </div>
          </v-col>
        </v-row>

        <!-- 퍼스널 컬러 기능 소개 -->
        <v-row class="mb-6 menu-row" justify="center" no-gutters v-show="page === 3">
          <v-col lg="4">
            <img :src="image[2]"/>
          </v-col>
          <v-col lg="1"></v-col>
          <v-col class="menu-detail" lg="4">
            <div class="menu-detail-title">내 패션 성향 알아보기</div>
            <div class="menu-detail-content">
              패피티아이를 통해 <br>
              숨은 내 스타일 성향을 알아보고<br>
              친구들과 공유해보세요 !
            </div>
            <div class="menu-btn" @click="changePage(2)">
              FPTI (패피티아이) 시작하기
            </div>
          </v-col>
        </v-row>

        <!-- 서비스 시작하기 -->
        <!-- <v-row class="mb-6 menu-row" justify="center" no-gutters v-show="page === 4">
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
            <div class="menu-btn" @click="changePage(4)">
              서비스 시작하기
            </div>
          </v-col>
        </v-row> -->
      </v-container>
      <div class="progress-container">
        <div class="progress" @click="nextPage(1)" />
        <div class="progress" @click="nextPage(2)" />
        <div class="progress" @click="nextPage(3)" />
        <!-- <div class="progress" @click="nextPage(4)" /> -->
      </div>
    </div>

  </div>
</template>

<script>
  import Snowf from 'vue-snowf';
  import { mapGetters } from 'vuex'
  export default {
    name: 'LandingSlider',
    components: {
      Snowf,
    },
    data: () => ({
      image: [
        require('@/assets/ex-search.png'),
        require('@/assets/ex-analyze.png'),
        require('@/assets/ex-fpti.png'),
        'https://post-phinf.pstatic.net/MjAyMTA0MDZfMjIw/MDAxNjE3Njk0NTYzMDIy.vh_iFhI2K6VWGCSX0ysqFr23aPnYqPTZkzpbUav7xRkg.AWMAI1T96OnWsGWPDDwHrkNCAgOlBho_S9cqzhArFg8g.JPEG/%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8_%EB%8F%84%EC%8B%9D%ED%99%94.jpg?type=w1200'
      ],
      btnColor: [
        '#F875AA',
        '#F875AA',
        '#F875AA',
        '#F875AA',
      ],
      pages: ['/searchResult', '/evaluationMain', '/fpti'],
      page: 1,
    }),
    computed: {
      ...mapGetters(["getSelectedUserStyle"]),
    },
    methods: {
      nextPage(page) {
        this.page = page
        this.moveFocusing(page)
      },
      changePage(index) {
        if (index == 0 && this.getSelectedUserStyle == null) {
          this.$router.push('/chooseStyle')
          return
        }
        this.$router.push(this.pages[index])
      },
      clearFocusing() {
        const menu = document.getElementsByClassName('menu')
        const progress = document.getElementsByClassName('progress')
        for (let i = 0; i < menu.length; i++) {
          menu[i].style.color = 'hotpink' // <- menu hover 문제
          // menu[i].classList.remove('menu')
          progress[i].style.background = 'white'
          progress[i].style.borderColor = '#e4d2d2'
        }
      },
      moveFocusing(index) {
        this.clearFocusing()
        const menu = document.querySelector(`.menu:nth-child(${index})`)
        const progress = document.querySelector(`.progress:nth-child(${index})`)
        menu.style.color = '#e25959'
        progress.style.background = this.btnColor[index - 1]
        progress.style.borderColor = this.btnColor[index - 1]
      },
    },
    mounted() {
      // 슬라이더 첫 메뉴 초기 선택
      const firstProgress = document.getElementsByClassName('progress')[0]
      firstProgress.style.background = '#F975AA'
      firstProgress.style.borderColor = '#F975AA'
      document.getElementsByClassName('menu')[0].style.color = '#e25959'
    },
  }
</script>

<style scoped>
.slider {
  width: 80%;
  margin-left: 10%;
  height: 45vh;
  text-align: center;
}
img {
  width: 25vw;
  height: 250px;
}
.progress-container {
  text-align: center;
  height: 100px;
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
  font-family: 'Cafe24Ssurround';
  font-size: 1.5rem;
  color: #F975AA;
  cursor: pointer;
  z-index: 2;
}
.menu:hover {
  color: rgb(226, 89, 89);
}
.menu-detail {
  font-family: Cafe24Ssurround;
  text-align: left;
  z-index: 2;
}
.menu-detail-title {
  font-size: 2rem;
}
.menu-detail-content {
  margin-top: 1.5rem;
  font-size: 1.2rem;
  font-family: ELAND_Choice_M;
}
.menu-btn {
  text-align: center;
  margin-top: 3rem;
  border-radius: 20px;
  padding: 10px;
  cursor: pointer;
  color: white;
  font-family: ELAND_Choice_M;
  background-color: #F875AA;
}
.menu-btn:hover {
  background-color: #F1D1D0;
  color: #F875AA;
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
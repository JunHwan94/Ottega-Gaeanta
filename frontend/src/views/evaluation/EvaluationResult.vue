<template>
  <div class="result-container">
    <div class="test">Ottega-Gaeanta</div>
    <!-- <div class="test">Ottega-Gaeanta</div>
    <div class="test">Ottega-Gaeanta</div>
    <div class="test">Ottega-Gaeanta</div>
    <div class="test">Ottega-Gaeanta</div> -->
    <div class="top" align="center">
      <div id="sub-title">내 스타일은 어떨까?</div>
      <div id="main-title" ><span style="background: linear-gradient(to top, #f875aa 40%, transparent 40%);">의상 평가 결과</span></div>
      
    </div>
    <div class="area-divider"></div>
    <div class="content-area" align="center">
      <div class="card">
        <div class="section">
          <h2>도저히 이쁜 색 조합을 못찾겠다고?</h2>
        </div>
        <img :src="colorCombinationImg" class="color-image" style="overflow: hidden; width:60%; height: 55%;" />
        <div class="section">
          <div class="btn" @click="move(0)">
            <span class="btn-text">169가지 색 조합표 <br>둘러보기</span>
            <!-- <h7>169가지 색 조합표 <br>둘러보기</h7> -->
          </div>
        </div>
      </div>
      <div class="card" style="left: 37vw;">
        <div class="section">
          <h2>색상 조합만 잘 해도 반은간다!</h2>
          <div style="display: inline-block;">
            <img :src="userImage" class="user-image">
          </div>
          <div style="display: inline-block; line-height: 30px;">
            <span class="rank" style="font-family: Binggrae-Bold;">{{ getUserFashionRate.rank }}</span>
          </div>
          <br><br>
          <span v-for="tag in getUserFashionRate.hashtag" :key="tag">
            {{tag}}
          </span>
        </div>
        <div class="section" style="width: 60%">
          {{getUserFashionRate.desc}}
        </div>
        <div class="section">
          <div class="btn" @click="move(1)">
            <!-- <h7>색 조합 분석 <br>다시하기</h7> -->
            <span class="btn-text">색 조합 분석 <br>다시하기</span>
          </div>
        </div>
      </div>
      
      <div class="card" style="left: 64vw;">
        <div class="section">
          <h2>비슷한 색상으로 스타일링한 옷은?</h2>
        </div>
        <div style="display: inline-block;">
          <img :src="recommendImages[0]" class="recommend-image" />
          <img :src="recommendImages[1]" class="recommend-image" />
        </div>
        <div>
          <img :src="recommendImages[2]" class="recommend-image" />
          <img :src="recommendImages[0]" class="recommend-image" />
        </div>
        <div class="btn" @click="move(2)">
          <span class="btn-text">다른 스타일 <br>둘러보기</span>
          <!-- <h7>다른 스타일 <br>둘러보기</h7> -->
        </div>
      </div>
    </div>

    <!-- <div class="evaluation" align="center">
      <v-row>
        <v-col lg=2></v-col>
        <v-col class="evaluation-comment" lg=4>
          색상 매칭만 잘해도 반은 간다!<br>
          <span>
            의상 진단 결과 아주 양호 합니다!<br>
            흰색 티셔츠와 검은색 진, 잘 어울리는 조합입니다.<br>
            님 좀 입는듯!?
          </span>
        </v-col>
        <v-col lg=4>
          <div class="card">
            <p>오늘 당신의 코디 점수는? </p><br>
            <v-row>
              <v-col lg=6 align="center">
                <img class="evaluation-img" :src="mainImageUrl" />
              </v-col>
              <v-col lg=6 align="center"><br>
                <div class="rate">{{getUserFashionRate.rank}}</div>
              </v-col>
            </v-row>
            <div>한줄 평 <br> 색 상 조합에 조금만 더 신경을 기울이면<br> 좋은 스타일링이 가능할 것 같습니다 화이팅!</div>
          </div>
        </v-col>
        <v-col lg=2></v-col>
      </v-row>
    </div>
    <div class="area-divider"></div>
    <div class="color-area" align="center">
      <v-row>
        <v-col lg=2></v-col>
        <v-col lg=4>
          <div class="color-card">
            <img :src="colorCombinationImg"/>
          </div>
        </v-col>
        <v-col lg=4>
          <div class="color-comment">
            <div class="area-divider"></div>
            색상 조합 이렇게 다양합니다<br> 이 기준에 맞춰서 옷을 입으면 조금 더 나은 스타일링이 가능하겠죠!?<br><br>
            서비스를 지속적으로 이용하면서 자신만의 컬러 조합과 스타일을 만들어보세요<br>
          </div>
        </v-col>
        <v-col lg=2></v-col>
      </v-row>
    </div>
    <div class="area-divider"></div>
    <div class="recommend-area" align="center">
      <div class="recommend-title" align="left">
        같은 색상으로 스타일링한 다른 옷
      </div>
      <div class="recommend-detail" >
        <div class="recommend-item" v-for="img in recommendImages" v-bind:key="img">
          <img :src="img" />
        </div>
      </div>
      <div class="btn" @click="move()">
        <h2>비슷한 색 조합 의상 둘러보기</h2>
      </div>
      <div>
      </div>
    </div> -->

  </div>
</template>

<script>
  import {
    mapGetters
  } from 'vuex'
  export default {
    data: () => ({
      userImage: require('@/assets/evaluation-model.png'),
      colorCombinationImg: require('@/assets/color-combi.jpg'),
      recommendImages: [
        require('@/assets/evalResult-sample-1.jpg'),
        require('@/assets/evalResult-sample-2.jpg'),
        require('@/assets/evalResult-sample-3.jpg'),
      ],
      getUserFashionRate: {
        "rank": "A",
        "desc": "A! 무슨 색으로 상하의 조합을 맞추어야 이쁘고 멋있게 보일지 아시는 분!",
        "hashtag": ["# 왕", "# 색조합마스터"],
      },
    }),
    computed: {
      // ...mapGetters(["getUserFashionRate"]),
    },
    methods: {
      move(i) {
        const page = ['evaluationMain/','evaluationMain/','searchResult/']
        if (i == 0) {
          this.$store.commit('SAVE_COLOR_MODAL_STATE', true)
        }
        this.$router.push(page[i])
      }
    }
  }
</script>

<style scoped>
  .result-container {
    padding-top: 4rem;
    height: 100vh;
    width: 100vw;
    background: linear-gradient(to bottom right, #FBACCC, #F1D1D0, white);
    font-family: Binggrae-Bold;
  }

  .top {
    margin-top: 5vh;
  }

  #sub-title {
    font-size: 15px;
  }

  #main-title {
    font-size: 35px;
  }

  .area-divider {
    /* width: 100%;
  height: 5vw; */
  }

  .content-area {
    /* background-color: red; */
    width: 100%;
    margin-top: 5vh;
    margin-left: 10%;
    /* height: 100%; */
    /* padding: 0px 15%; */
  }

  .card {
    width: 25%;
    height: 60vh;
    position: absolute;
    background-color: #F4F9F9;
    border-radius: 30px;
    box-shadow: 3px 3px 3px 3px #FBACCC;
    margin-left: 30px;
    float: left;
    border: 1px solid #FBACCC;
    z-index: 0;
  }

  .color-image {
    overflow: hidden;
    padding: 20px;
    width: 100%;
    height: 100%;
  }

  .user-image {
    margin-top: 20px;
    width: 150px;
    height: 150px;
    border-radius: 100px;
    border: 1px solid black;
    vertical-align: middle;
  }

  .recommend-image {
    margin-top: 30px;
    margin-left: 10px;
    margin-right: 10px;
    width: 120px;
    height: 120px;
    border-radius: 100px;
    border: 1px solid black;
  }

  .rank {
    font-size: 50px;
    color: red;
    margin-left: 60px;
    /* line-height: -10px; */
  }

  .section {
    margin-top: 50px;
  }

  .btn {
    border: 2px solid #F875AA;
    padding: 10px;
    width: 200px;
    border-radius: 20px;
    background-color: #F4F9F9;
    cursor: pointer;
    color: #F875AA;
    margin-top: 5vh;
  }
  btn-text {
    font-size: 30px;
  }
  .btn:hover {
    color: white;
    background-color: #F875AA;
  }
  .test {
    position: absolute;
    top: 0;
    left: 20px;
    font-weight: 900;
    font-size: 150px;
    line-height: 240px;
    transform: translate(0px, 30px) rotate(-10deg);
    animation: move 4s ease-in-out infinite;
  }
  @keyframes move {
  0% {
    transform: translate(0px, 30px) rotate(-10deg);
    color: rgba(179, 54, 54, 0.2);
  }
  50% {
    transform: translate(0px, 50px) rotate(-10deg);
    color: rgba(202, 39, 39, 0.2);
  }
  100% {
    transform: translate(0px, 30px) rotate(-10deg);
    color: rgba(255, 255, 255, 0.2);
  }
}
</style>
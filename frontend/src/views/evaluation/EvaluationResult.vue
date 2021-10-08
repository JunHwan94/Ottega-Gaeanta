<template>
  <div class="result-container">
    <div class="test">Ottega-Gaeanta</div>
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
        <div class="card-body">
          <img :src="colorCombinationImg" class="color-image" style="overflow: hidden; width:60%; height: 100%;" />
        </div>
        <div class="btn-area">
          <div class="btn" @click="move(0)">
            <span class="btn-text">색 조합 평가방식 <br>보러가기</span>
          </div>
        </div>
      </div>
      <div class="card" style="left: 37vw;">
        <div class="section">
          <h2>색상 조합만 잘 해도 반은간다!</h2>
          <div class="card-body">
            <div style="display: inline-block; margin-right: 10px;">
              <img :src="getUserEvaluationImage" class="user-image mb-5">
            </div>
            <div style="display: inline-block; margin-left: 10px;" >
              <div style="">
                <span class="rank">{{ getUserFashionRate.rank }} 등급</span>
              </div>
            <div>
              상의 색상 : {{getUserFashionRate.top}}<br>
              하의 색상 : {{getUserFashionRate.pants}}
            </div>
              
            </div>
            <div>
              <span v-for="tag in getUserFashionRate.hashtag" :key="tag" style="color: blue;">
                {{tag}}
              </span>
            </div>
            <br>
            <div style="width: 70%">
              {{getUserFashionRate.desc}}
            </div>
          </div>
          <div class="btn-area">
            <div class="btn" @click="move(1)">
              <span class="btn-text">색 조합 분석 <br>다시하기</span>
            </div>
          </div>

        </div>
      </div>
      
      <div class="card" style="left: 64vw;">
        <div class="section">
          <h2>비슷한 색상으로 스타일링한 옷은?</h2>
        </div>
        <div class="card-body">
          <div style="display: inline-block;">
            <img v-if="getEvalSameColorStyle[0]" :src="getEvalSameColorStyle[0]" class="recommend-image" />
            <img v-if="getEvalSameColorStyle[1]" :src="getEvalSameColorStyle[1]" class="recommend-image" />
          </div>  
          <div>
            <img v-if="getEvalSameColorStyle[2]" :src="getEvalSameColorStyle[2]" class="recommend-image" />
            <img v-if="getEvalSameColorStyle[3]" :src="getEvalSameColorStyle[3]" class="recommend-image" />
          </div>
        </div>
        <div class="btn-area">
          <div class="btn" @click="move(2)">
            <span class="btn-text">다른 스타일 <br>둘러보기</span>
          </div>
        </div>
      </div>
    </div>
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
      // getUserFashionRate: {
      //   "rank": "A",
      //   "desc": "A! 무슨 색으로 상하의 조합을 맞추어야 이쁘고 멋있게 보일지 아시는 분!",
      //   "hashtag": ["# 왕", "# 색조합마스터"],
      // },
    }),
    computed: {
      // ...mapGetters(["getUserFashionRate"]),
      ...mapGetters(['getEvalSameColorStyle', 'getUserFashionRate', 'getUserEvaluationImage'])
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
    border: 3px solid #FBACCC;
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
    width: 200px;
    height: 200px;
    border-radius: 15px;
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
    font-size: 40px;
    color: red;
    /* margin-left: 60px; */
    /* line-height: -10px; */
  }

  .section {
    margin-top: 50px;
  }

  .btn {
    border: 3px solid #F875AA;
    padding: 10px;
    width: 200px;
    border-radius: 20px;
    background-color: #F4F9F9;
    cursor: pointer;
    color: #F875AA;
  }
  .btn-area { 
    margin-top: 3vh;
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
  .card-body {
    height: 35vh;
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
<template>
  <div class="result-container">
    <div class="top" align="center">
      <div id="sub-title">내 스타일은 어떨까?</div>
      <div id="main-title">의상 진단 평가</div>
    </div>
    <div class="area-divider"></div>
    <div class="evaluation" align="center">
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
    </div>

  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  export default {
    data: () => ({
      mainImageUrl: require('@/assets/evaluation-model.png'),
      colorCombinationImg: require('@/assets/color-combi.jpg'),
      recommendImages: [
        require('@/assets/evalResult-sample-1.jpg'),
        require('@/assets/evalResult-sample-2.jpg'),
        require('@/assets/evalResult-sample-3.jpg'),
      ]
    }),
    computed: {
    ...mapGetters(["getUserFashionRate"]),
    },
    methods: {
      move() {
        this.$router.push('searchResult/')
      }
    }
  }
</script>

<style scoped>
.result-container {
  padding-top: 4rem;
  height: 250vh;
  width: 100vw;
  background: linear-gradient(to bottom right, #FBACCC, #F1D1D0, white);
  font-family: Binggrae-Bold;
}
.rate {
  font-size: 50px;
  color: red;
}
.top {
  margin-top: 5em;
}

.top div {
  font-family: Binggrae-Bold;
}

#sub-title {
  font-size: 20px;
}

#main-title {
  font-size: 50px;
}
.color-card {
  box-shadow: 3px 3px 3px 3px rgb(226, 171, 99);
  border-radius: 30px;
  width: 25vw;
  height: 100%;
  overflow: hidden;
  padding: 20px;
  background: white;
}
.card {
  /* border: 2px solid black; */
  box-shadow: 3px 3px 3px 3px rgb(226, 171, 99);
  width: 25vw;
  height: 400px;
  border-radius: 30px;
  padding: 20px;
  background: #F4F9F9;
}

.card>p {
  font-size: 2rem;
}

.evaluation-comment {
  font-size: 40px;
}

.evaluation-comment > span{
  font-size: 20px;
}

.area-divider {
  width: 100%;
  height: 5vw;
}
.color-card > img {
  width: 100%;
  height: 100%;
}
.evaluation-img {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  border: 2px solid orange;
}
.color-comment {
  font-size: 2rem;
}
.recommend-title {
  margin-left: 20vw;
  font-size: 2.5rem;
}
.recommend-detail {
  margin-top: 2rem;
}
.recommend-item {
  display: inline-block;
  width: 300px;
  height: 300px;
  cursor: pointer;
  border-radius: 45%;
  overflow: hidden;
  margin: 30px 30px;
}
.recommend-item:hover {
  border: 2px solid #F875AA;
}
.recommend-detail img {
  width: 100%;
  height: 100%;

}
.btn {
  border: 2px solid #F875AA;
  padding: 10px;
  width: 400px;
  border-radius: 20px;
  background-color: #F875AA;
  cursor: pointer;
  color: white;
  margin-top: 5vh;
}
</style>
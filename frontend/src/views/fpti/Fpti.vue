<template>
  <div class="fpti-container">
    <!-- <div class="" align="center"> 
      <h2>내 성격에 딱!<br>어울리는 룩은?</h2><br>
      <h4>룩으로 알아보는 내 패션성향, FPTI</h4>
    </div> -->
    <!-- {{getSurveys}} -->
    <div align="center" style="margin-top:-50px;">
    <!-- <vueper-slides class="in" :touchable="false" :bullets="false" :arrows="false" ref="first">
      <vueper-slide
        :key="1"
        :style="'background-color: #42b983'" >
        
        <template v-slot:content>
          <div><h1>dsasa</h1></div>
          <div><h1>dsasa</h1></div>
          <div><h1>dsasa</h1></div>
          <div><h1>dsasa</h1></div>
          <div><h1>dsasa</h1></div>
          <div>
            ID: <input type="text"/><br/>
            PW: <input type="text"/><br/>
            <button @click="$refs.first.next()">다음</button>
          </div>
        </template>
      </vueper-slide>
      <vueper-slide
        :key="2"
        :style="'background-color: #42b983'">
        <template v-slot:content>
          <div>
            나이: <input type="text"/><br/>
            주소: <input type="text"/><br/>
            <button @click="$refs.first.previous()">이전</button>
            <button @click="$refs.first.next()">다음</button>
          </div>
        </template>
      </vueper-slide>
      <vueper-slide
        :key="3"
        :style="'background-color: #42b983'">
        <template v-slot:content>
          <div>
            자기소개: <textarea/><br/>
            <button @click="$refs.first.previous()">이전</button>
            <button v-on:click="showAlert('가입을 축하드립니다')">가입완료</button>
          </div>
        </template>
      </vueper-slide>
    </vueper-slides> -->
    <vueper-slides 3d class="no-shadow slider" fixed-height="500px" :arrows="false" :touchable="false" ref="fpti" bullets-outside transition-speed="250">
      <vueper-slide
        class="frame"
        :key="111">
        <template v-slot:content>
          <div class="mt-12">
            <h2>내 성격에 딱!<br>어울리는 룩은?</h2><br>
            <h4>룩으로 알아보는 내 패션성향, FPTI</h4>
            <div class="mt-5">
              <img :src="mainImage"/>
            </div>
            <div class="btn mt-5" @click="$refs.fpti.next()">
              패피티아이 시작~!
            </div>
          </div>
        </template>
      </vueper-slide>
      <vueper-slide
        class="frame"
        v-for="survey in getSurveys"
        :key="survey.qno">
        <template v-slot:content>
          <div class="mt-12">
            <div>
              <h3>Q{{survey.qno}}. {{survey.question}}</h3>  
            </div>
            <div v-for="(answer, index) in survey.answerList" :key="index">
              <h5>{{answer}}</h5>  
            </div>
          </div>
        </template>
      </vueper-slide>
    </vueper-slides>
  </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { VueperSlides, VueperSlide } from 'vueperslides'
import 'vueperslides/dist/vueperslides.css'
export default {
  components: {
    VueperSlides, VueperSlide
  },
  computed: {
    ...mapGetters(["getSurveys"]),
  },
  data: () => ({
    mainImage: require('@/assets/fpti/main.png')
  }),
  created() {
    this.$store.dispatch('getSurveys')
      .then((response) => {
        console.log(response.data.surveys);
        this.$store.commit('SAVE_FPTI_SURVEYS', response.data.surveys)
      })
  },
  mounted() {
  }
}
</script>

<style scoped>
.fpti-container {
  margin-top: 15rem;
  /* height: 100vh; */
}
.slider {
  width: 350px;
}
.frame {
  border: 1px solid black; 
  background-color: white;
}
img {
  width: 200px;
  height: 200px;
}
.btn {
  width: 300px;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
  background-color: #F875AA;
  color: white;
  cursor: pointer;
  font-weight: bold;
}
.btn:hover {
  background-color: black;
}
</style>
<template>
  <div id="div-container">
    <div align="center" style="margin-top: 5rem;">
      <v-card style="width: 30rem;">
        <h1 style="text-align: center;">패피티아이(FPTI) 진단 결과</h1>
        <h1 style="text-align: center; color: #F875AA; margin-top: 5px;">당신은?</h1>
        <v-img :src="fptiResult.iconUrl"></v-img>
        <br>
        <div style="height: 7rem; vertical-align: middle; background-color: #333333">
          <div class="d-flex pt-3" style="justify-content: center; display: inline-block;">
            <span style="color: white; text-align: center; font-size: 1rem;">Your</span>
            &nbsp;&nbsp;
            <span style="color: white; text-align: center;">St.</span>
          </div>
          <h1 style="color: white; text-align: center; text-decoration: underline;">{{fptiResult.fptiName}}</h1>
        </div>
        <br><br><br>
        <div class="">
          <span v-for="tag in fptiResult.hashtag" :key="tag" style="color: #FBACCC; margin-left: 20px; font-family: Cafe24Ssurround; font-size: 1.2rem;">{{ tag }}</span>
        </div>
        <br>
        <h2>{{fptiResult.title}}</h2>
        <div class="mx-3 mt-3">
          <h5 style="font-size: 1.2rem; ">{{fptiResult.desc}}</h5>
        </div>
        <br><br><br>
        <!-- <h2 style="color: #F875AA; text-align: center; font-family: Cafe24Ssurround;">{{ fptiResult.comment }}</h2> -->
        <br>
        <div style="background-color: #F1D1D0; height: 450px;">
          <div style="height: 40px;"></div>
          <div class="pt-2">
            <h2 style="color: #F875AA; text-align: center; font-family: Cafe24Ssurround;">{{ fptiResult.comment }}</h2>
          </div>
          <v-row>
            <v-col v-for="idx in 3" :key="idx" cols="4">
              <v-avatar :size="sizeArray[idx-1]" :style="'margin-top:'+paddingArray[idx-1]+';'+'padding: 0px;'" id="avatarImg">
                <img :src="fptiResult.bgImgUrl[idx-1]" style="border: 5px solid #FBACCC;">
              </v-avatar>
            </v-col>
          </v-row>
          <div style="height: 30px;"></div>
          <v-btn @click="goToSearch" id="goSearchBtn" style="color: #F875AA; text-align: right; font-family: Cafe24Ssurround; margin-right: 20px; width: 250px;">패션 검색 gogo -></v-btn>
        </div>
        <div style="background-color: #F4F9F9; height: 300px;">
          <div style="height: 50px;"></div>
          <div class="">
            <h2 style="color: #F875AA; text-align: center; font-family: Cafe24Ssurround;">패피티아이 결과를</h2>
            <div class="d-flex" style="margin-left: 15%">
              <h1 style="color: #222222; text-align: center; font-family: Cafe24Ssurround;">친구들과</h1>&nbsp;&nbsp;&nbsp;
              <h1 style="color: #F875AA; text-align: center; font-family: Cafe24Ssurround;">공유해보세요!</h1>
            </div>
          </div>
          <div style="height: 50px;"></div>
          <!-- 카카오 공유 -->
          <div>
            <img src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png" alt="kakao" @click="sendkakao" id="kakao-share">
          </div>
        </div>
        <div style="background-color: #333333; height: 170px;">
          <div style="height: 20px;"></div>
          <div class="d-flex" style="margin-left: 15%">
            <h2 style="color: #FFFFFF; text-align: center; font-family: Cafe24Ssurround;">나의&nbsp;</h2>
            <h2 style="color: #F875AA; text-align: center; font-family: Cafe24Ssurround;">스타일 취향</h2>
            <h2 style="color: #FFFFFF; text-align: center; font-family: Cafe24Ssurround;">이 궁금하다면?</h2>
          </div>
          <br>
          <div>
            <v-btn @click="retryFpti" id="goSearchBtn" style="color: #F875AA; text-align: right; font-family: Cafe24Ssurround; margin-right: 20px; width: 250px; height: 40px; font-size: 1.1rem;">패피티아이 시작하기</v-btn>
          </div>
        </div>
      </v-card>
      <div style="height: 100px;"></div>
    </div>
  </div>
</template>

<script>
import SearchResult from '@/views/search/SearchResult.vue'
import Fpti from '@/views/fpti/Fpti.vue'
import { mapActions, mapState } from 'vuex'
export default {
  components: {
    SearchResult,
    Fpti,
  },
  computed: {
    ...mapState([
      'fptiResult',
      'selectedUserStyle',
    ]),
  },
  data () {
    return {
      typeno: this.$route.params.typeno,
      sizeArray: ['8.5rem','10rem','9rem'],
      paddingArray: ['10%','60%','25%'],
    }
  },
  methods: {
    goToSearch () {
      if (this.selectedUserStyle === null) {
        this.$router.push({name: 'ChooseStyle'})
      } else {
        this.$router.push({name: 'SearchResult'})
      }
    },
    retryFpti () {
      this.$router.push({name: 'Fpti'})
    },
    sendkakao: function () {
      Kakao.Link.createDefaultButton({ 
        container: '#kakao-share',
        objectType: 'feed', 
        content: { 
          title: 'Ottega-Gaeanta 패피티아이 진단 결과', 
          description: '당신은 어떤 스타일? Ottega-Gaeanta에서 확인하세요',
          imageUrl: 'https://cc-prod.scene7.com/is/image/CCProdAuthor/Fashion-illustration_P1_900x420?$pjpeg$&jpegSize=200&wid=900',
          // imageUrl: require('@/assets/main.png'),
          link: {
            // mobileWebUrl: `http://localhost:8080/fptiResult/${this.fptiResult.typeno}`, 
            // webUrl: `http://localhost:8080/fptiResult/${this.fptiResult.typeno}`, 
            mobileWebUrl: `https://j5b206.p.ssafy.io/fptiResult/${this.fptiResult.typeno}`, 
            webUrl: `https://j5b206.p.ssafy.io/fptiResult/${this.fptiResult.typeno}`, 
          }, 
        }, 
        buttons: [ { 
          title: '웹으로 보기', 
          link: { 
            // mobileWebUrl: `http://localhost:8080/fptiResult/${this.fptiResult.typeno}`, 
            // webUrl: `http://localhost:8080/fptiResult/${this.fptiResult.typeno}`, 
            mobileWebUrl: `https://j5b206.p.ssafy.io/fptiResult/${this.fptiResult.typeno}`, 
            webUrl: `https://j5b206.p.ssafy.io/fptiResult/${this.fptiResult.typeno}`, 
          }, 
        }, ], 
      }) 
    },
  },
  created () {
    this.$store.dispatch('getFptiResultFromKakaoShare', this.typeno)
      .then((response) => {
        this.$store.commit('SAVE_FPTI_RESULT', response.data.type)
      })
  },
}
</script>

<style>
#goSearchBtn:hover {
  background-color: #FBACCC;
  color: #FBACCC;
  cursor: pointer;
}
#kakao-share:hover {
  cursor: pointer;
}
</style>
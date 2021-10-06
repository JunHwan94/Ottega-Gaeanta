<template>
  <div class="text-center">
    <v-dialog
      v-model="showSearchDetail"
      persistent
      width="70%"
      height="50%"
    >
      <!-- 플립북 -->
      <section>
        <v-card>
          <div id="flipbook1" @click="goFlip" :style="flipCSS">
          </div>
          <div id="flipbook3" @click="goFlip" :style="flipCSS">
          </div>
          <div id="flipbook4" @click="goFlip" :style="flipCSS">
          </div>
          <div id="flipbook5" @click="goFlip" :style="flipCSS">
          </div>
          <div id="flipbook6" @click="goFlip" :style="flipCSS">
          </div>
          <div id="flipbook7" @click="goFlip" :style="flipCSS">
            <div style="">
              <v-img 
                :src="searchDetailImageURL" 
                alt="image" 
                style="width: 50%; height: 50%; margin-left: 25%; margin-top: 10%; border-radius: 50px"
              >
              </v-img>
              <h1 :style="flipCSS3">상세보기 -> </h1>
            </div>
          </div>

          <!-- 코디 정보 -->
          <div id="infobook1" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem; padding-left: 1rem;"></div>
          <div id="infobook3" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem; padding-left: 1rem;"></div>
          <div id="infobook4" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem; padding-left: 1rem;"></div>
          <div id="infobook5" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem; padding-left: 1rem;"></div>
          <div id="infobook6" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem; padding-left: 1rem;"></div>
          <div id="infobook7" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 1.3rem; padding-left: 1rem;">
            <!-- 유사 스타일 -->
            <div style="margin-bottom: 2%;">
              <h4 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%;">SUB</h4>
              <div style="margin-top: 1%;" v-if="simillarStyles.length !== 0">
                <v-row>
                  <v-col cols=1></v-col>
                  <v-col v-for="(simillarStyle, idx) in simillarStyles" :key="idx" cols=3>
                    <img :src="simillarStyle.sturl" alt="image" style="height: 15vh; width: 13vh; border-radius: 2vh;">
                  </v-col>
                  <v-col cols=1>
                    <div style="height: 15vh;">
                      &nbsp;
                    </div>
                  </v-col>
                </v-row>
              </div>
              <div style="margin-top: 1%;" v-if="simillarStyles.length === 0">
                <div style="height: 15vh;" align="center">
                  <div style="padding-top: 6vh;">
                    <span>추천할만한 유사 스타일 룩이 없습니다</span>
                  </div>
                </div>
              </div>
            </div>
            <hr>
            <!-- 패션 정보 -->
            <div style="margin-bottom: 2%; margin-top: 1%">
              <h4 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin: 2%;">스타일</h4>
              <div class="d-flex" style="padding-left: 15%;">
                <span style="font-size: 1.2rem; font-family: ELAND_Choice_M;">#{{ imageDetail.style[0].style }}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                <span style="font-size: 1.2rem; font-family: ELAND_Choice_M;" v-if="imageDetail.style[0].subStyle !== null">#{{ imageDetail.style[0].subStyle }}</span>
              </div>
            </div>
            <hr>
            <!-- 아우터 -->
            <div style="margin-top: 2%;" v-if="!isEmptyObject(imageDetail.outer[0])">
              <h4 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%; margin-top: 1%; margin-bottom: 2%">아우터</h4>
              <div align="center">
                <span v-if="imageDetail.outer[0].category" :style="fashionInfoStyle">이&nbsp;</span>
                <span v-if="imageDetail.outer[0].category" :style="fashionInfoLabelStyle">{{ imageDetail.outer[0].category }}</span>
                <span v-if="imageDetail.outer[0].category" :style="fashionInfoStyle">은(는)&nbsp;</span>
                <span v-if="imageDetail.outer[0].color" :style="fashionInfoLabelStyle">{{ imageDetail.outer[0].color }}&nbsp;</span>
                <span v-if="imageDetail.outer[0].color" :style="fashionInfoStyle">색상에,&nbsp;</span>
                <span v-if="imageDetail.outer[0].length" :style="fashionInfoLabelStyle">{{ imageDetail.outer[0].length }}&nbsp;</span>
                <span v-if="imageDetail.outer[0].length" :style="fashionInfoStyle">기장,&nbsp;</span>
                <span v-if="imageDetail.outer[0].material" :style="fashionInfoLabelStyle">{{ imageDetail.outer[0].material[0] }}&nbsp;</span>
                <span v-if="imageDetail.outer[0].material" :style="fashionInfoStyle">소재로 이루어진&nbsp;</span>
                <span v-if="imageDetail.outer[0].fit" :style="fashionInfoLabelStyle">{{ imageDetail.outer[0].fit }}핏&nbsp;</span>
                <span :style="fashionInfoStyle">아우터입니다.&nbsp;</span>
              </div>
              <div align="center" v-if="imageDetail.outer[0].print !== undefined">
                <div v-if="imageDetail.outer[0].print.length !== 0">
                  <span :style="fashionInfoStyle">디자인은&nbsp;</span>
                  <span :style="fashionInfoLabelStyle" v-for="design in imageDetail.outer[0].print" :key="design" style="font-size: 0.9rem; font-family: ELAND_Choice_M;">'{{ design }}'&nbsp;</span>
                  <span :style="fashionInfoStyle">이 있습니다.</span>
                </div>
              </div>
            </div>

            <!-- 원피스 -->
            <div style="margin-top: 2%; " v-if="!isEmptyObject(imageDetail.onepiece[0])">
              <h4 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%; margin-top: 1%; margin-bottom: 2%">원피스</h4>
              <div align="center">
                <span v-if="imageDetail.onepiece[0].category" :style="fashionInfoStyle">이&nbsp;</span>
                <span v-if="imageDetail.onepiece[0].category" :style="fashionInfoLabelStyle">{{ imageDetail.onepiece[0].category }}</span>
                <span v-if="imageDetail.onepiece[0].category" :style="fashionInfoStyle">은(는)&nbsp;</span>
                <span v-if="imageDetail.onepiece[0].color" :style="fashionInfoLabelStyle">{{ imageDetail.onepiece[0].color }}&nbsp;</span>
                <span v-if="imageDetail.onepiece[0].color" :style="fashionInfoStyle">색상에,&nbsp;</span>
                <span v-if="imageDetail.onepiece[0].length" :style="fashionInfoLabelStyle">{{ imageDetail.onepiece[0].length }}&nbsp;</span>
                <span v-if="imageDetail.onepiece[0].length" :style="fashionInfoStyle">기장,&nbsp;</span>
                <span v-if="imageDetail.onepiece[0].material" :style="fashionInfoLabelStyle">{{ imageDetail.onepiece[0].material[0] }}&nbsp;</span>
                <span v-if="imageDetail.onepiece[0].material" :style="fashionInfoStyle">소재로 이루어진&nbsp;</span>
                <span v-if="imageDetail.onepiece[0].fit" :style="fashionInfoLabelStyle">{{ imageDetail.onepiece[0].fit }}핏&nbsp;</span>
                <span :style="fashionInfoStyle">원피스입니다.&nbsp;</span>
              </div>
              <div>
                <v-row justify="center">
                  <div align="center">
                    <span v-if="imageDetail.onepiece[0].neckLine" :style="fashionInfoLabelStyle">{{ imageDetail.onepiece[0].neckLine }}</span>
                    <span v-if="imageDetail.onepiece[0].neckLine" :style="fashionInfoStyle">의 넥라인,&nbsp; </span>
                    <span v-if="imageDetail.onepiece[0].sleeveLength" :style="fashionInfoLabelStyle">{{ imageDetail.onepiece[0].sleeveLength }}</span>
                    <span v-if="imageDetail.onepiece[0].sleeveLength" :style="fashionInfoStyle">의 소매입니다.&nbsp;</span>
                  </div>
                  <div align="center" v-if="imageDetail.onepiece[0].print !== undefined">
                    <div v-if="imageDetail.onepiece[0].print.length !== 0">
                      <span :style="fashionInfoStyle">디자인은&nbsp;</span>
                      <span :style="fashionInfoLabelStyle" v-for="design in imageDetail.onepiece[0].print" :key="design" style="font-size: 0.9rem; font-family: ELAND_Choice_M;">'{{ design }}'&nbsp;</span>
                      <span :style="fashionInfoStyle">이 있습니다.</span>
                    </div>
                  </div>
                </v-row>
              </div>
            </div>

            <!-- 상의 -->
            <div style="margin-top: 2%; " v-if="!isEmptyObject(imageDetail.top[0])">
              <h4 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%; margin-top: 1%; margin-bottom: 2%">상의</h4>
              <div align="center">
                <span v-if="imageDetail.top[0].category" :style="fashionInfoStyle">이&nbsp;</span>
                <span v-if="imageDetail.top[0].category" :style="fashionInfoLabelStyle">{{ imageDetail.top[0].category }}</span>
                <span v-if="imageDetail.top[0].category" :style="fashionInfoStyle">은(는)&nbsp;</span>
                <span v-if="imageDetail.top[0].color" :style="fashionInfoLabelStyle">{{ imageDetail.top[0].color }}&nbsp;</span>
                <span v-if="imageDetail.top[0].color" :style="fashionInfoStyle">색상에,&nbsp;</span>
                <span v-if="imageDetail.top[0].length" :style="fashionInfoLabelStyle">{{ imageDetail.top[0].sleeveLength }}&nbsp;</span>
                <span v-if="imageDetail.top[0].length" :style="fashionInfoStyle">소매,&nbsp;</span>
                <span v-if="imageDetail.top[0].neckLine" :style="fashionInfoLabelStyle">{{ imageDetail.top[0].neckLine }}&nbsp;</span>
                <span v-if="imageDetail.top[0].neckLine" :style="fashionInfoStyle">넥라인으로 이루어진&nbsp;</span>
                <span v-if="imageDetail.top[0].fit" :style="fashionInfoLabelStyle">{{ imageDetail.top[0].fit }}핏&nbsp;</span>
                <span :style="fashionInfoStyle">상의입니다.&nbsp;</span>
              </div>
              <div align="center" v-if="imageDetail.top[0].print !== undefined">
                <div v-if="imageDetail.top[0].print.length !== 0">
                  <span :style="fashionInfoStyle">디자인은&nbsp;</span>
                  <span :style="fashionInfoLabelStyle" v-for="design in imageDetail.top[0].print" :key="design" style="font-size: 0.9rem; font-family: ELAND_Choice_M;">'{{ design }}'&nbsp;</span>
                  <span :style="fashionInfoStyle">이 있습니다.</span>
                </div>
              </div>
            </div>

            <!-- 하의 -->
            <div style="margin-top: 2%; " v-if="!isEmptyObject(imageDetail.bottom[0])">
              <h4 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%; margin-top: 1%; margin-bottom: 2%">하의</h4>
              <div align="center">
                <span v-if="imageDetail.bottom[0].category" :style="fashionInfoStyle">이&nbsp;</span>
                <span v-if="imageDetail.bottom[0].category" :style="fashionInfoLabelStyle">{{ imageDetail.bottom[0].category }}</span>
                <span v-if="imageDetail.bottom[0].category" :style="fashionInfoStyle">은(는)&nbsp;</span>
                <span v-if="imageDetail.bottom[0].color" :style="fashionInfoLabelStyle">{{ imageDetail.bottom[0].color }}&nbsp;</span>
                <span v-if="imageDetail.bottom[0].color" :style="fashionInfoStyle">색상에,&nbsp;</span>
                <span v-if="imageDetail.bottom[0].length" :style="fashionInfoLabelStyle">{{ imageDetail.bottom[0].length }}&nbsp;</span>
                <span v-if="imageDetail.bottom[0].length" :style="fashionInfoStyle">기장,&nbsp;</span>
                <span v-if="imageDetail.bottom[0].material" :style="fashionInfoLabelStyle">{{ imageDetail.bottom[0].material[0] }}&nbsp;</span>
                <span v-if="imageDetail.bottom[0].material" :style="fashionInfoStyle">소재로 이루어진&nbsp;</span>
                <span v-if="imageDetail.bottom[0].fit" :style="fashionInfoLabelStyle">{{ imageDetail.bottom[0].fit }}핏&nbsp;</span>
                <span :style="fashionInfoStyle">하의입니다.&nbsp;</span>
              </div>
              <div align="center" v-if="imageDetail.bottom[0].print !== undefined">
                <div v-if="imageDetail.bottom[0].print.length !== 0">
                  <span :style="fashionInfoStyle">디자인은&nbsp;</span>
                  <span :style="fashionInfoLabelStyle" v-for="design in imageDetail.bottom[0].print" :key="design" style="font-size: 0.9rem; font-family: ELAND_Choice_M;">'{{ design }}'&nbsp;</span>
                  <span :style="fashionInfoStyle">이 있습니다.</span>
                </div>
              </div>
            </div>
          </div>

          <v-card-actions style="height: 5vh">
            <v-spacer></v-spacer>
            <v-btn
              color="secondary"
              text
              @click="showStyleInfo({showSearchDetail, idx : '', imgURL : ''}); variableShowInitialize();"
            >
              <h1>X</h1>
            </v-btn>
          </v-card-actions>
        </v-card>
      </section>
      <!-- 플립북 끝 -->
      
    </v-dialog>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
// import Flipbook from 'flipbook-vue'

export default {
  name: 'SearchDetail',
  // props: {
  //   showSearchDetail: {
  //     type: Boolean,
  //   }
  // },
  components: { 
    // Flipbook 
  },
  data () {
    return {
      dialog: false,
      show: false,
      simillarStylesTemp: [
          "https://j5b206.s3.ap-northeast-2.amazonaws.com/클래식/GramMeterGroove_033_59.jpg", 
          "https://j5b206.s3.ap-northeast-2.amazonaws.com/프레피/20190315(샘플,중국)-최정임님-sk2271k93(3)-바비제이(샘플,프로썸SK)0315-모델-IMG_6541.jpg", 
          "https://j5b206.s3.ap-northeast-2.amazonaws.com/프레피/20180309(대행)13-jk1004(5931)IMG_0006.JPG"],
    }
  },
  computed: {
    ...mapState([
      'showSearchDetail',
      'searchDetailImageURL',

      // 이 친구가 해당 사진 정보 담고 있습니다.
      'imageDetail',

      // 유사스타일 리스트입니다.
      'simillarStyles'
    ]),
    flipCSS () {
      if (this.show) {
        return {
          transform: 'rotateY(-180deg) translateX(-17.5vw)',
          background: '#DDDDDD',
        }
      }
    },
    flipCSS2 () {
      if (this.show) {
        return {
          transform: 'translateX(17.5vw)',
          transition: '1.9s'
        }
      }
    },
    // 상세보기 글자색 변화 CSS
    flipCSS3 () {
      if (this.show) {
        return {
          transition: '1.5s',
          marginTop: '10%',
          fontFamily: 'Cafe24Ssurround',
          color: '#DDDDDD'
        }
      } else {
        return {
          transition: '1.5s',
          marginTop: '10%',
          fontFamily: 'Cafe24Ssurround',
          color: '#FBACCC',
        }
      }
    },
    fashionInfoStyle () {
      return {
        fontSize: '0.8rem',
        fontFamily: 'ELAND_Choice_M',
      }
    },
    fashionInfoLabelStyle () {
      return {
        fontSize: '0.8rem',
        fontFamily: 'ELAND_Choice_M',
        fontWeight: 'bold',
      }
    }
  },
  methods: {
    ...mapActions([
      'showStyleInfo'
    ]),
    goFlip () {
      this.show = !this.show
    },
    variableShowInitialize () {
      this.show = false
    },
    isEmptyObject (object) {
      return Object.keys(object).length === 0 && object.constructor === Object;
    },
  },
}
</script>

<style>
section{
  
  position: relative;
  width: 100vw;
  height: 80vh;
  perspective: 800vh;
}
#flipbook1 {
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 33vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #FFFFFF;
  transform-origin: left center;
  transition: 1.5s;
  z-index:5;
}
#flipbook3 {
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 32.7vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #FFFFFF;
  transform-origin: left center;
  transition: 1.6s;
  z-index:5;
}
#flipbook4 {
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 32.4vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #FFFFFF;
  transform-origin: left center;
  transition: 1.7s;
  z-index:5;
}
#flipbook5 {
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 32.1vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #FFFFFF;
  transform-origin: left center;
  transition: 1.8s;
  z-index:5;
}
#flipbook6 {
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 31.8vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #FFFFFF;
  transform-origin: left center;
  transition: 1.9s;
  z-index:5;
}
#flipbook7 {
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 31.5vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #FFFFFF;
  transform-origin: left center;
  transition: 2.0s;
  z-index:5;
}
#flipbook7:hover{
  transform: rotateY(-20deg);
  background: #F1F1F1;
  transition: 2.0s;
}

/* 패션 정보 북 */
#infobook1{
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 33vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #cba;
  transform-origin: left center;
  transition: 1.5s;   
  z-index: 4;
}
#infobook3{
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 32.7vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #cba;
  transform-origin: left center;
  transition: 1.5s;   
  z-index: 4;
}
#infobook4{
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 32.4vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #cba;
  transform-origin: left center;
  transition: 1.5s;   
  z-index: 4;
}
#infobook5{
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 32.1vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #cba;
  transform-origin: left center;
  transition: 1.5s;   
  z-index: 4;
}
#infobook6{
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 31.8vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #cba;
  transform-origin: left center;
  transition: 1.5s;   
  z-index: 4;
}
#infobook7{
  margin:5% auto;
  position:absolute;
  left: 25%;
  width: 31.5vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #cba;
  transform-origin: left center;
  transition: 1.5s;   
  z-index: 4;
}

</style>
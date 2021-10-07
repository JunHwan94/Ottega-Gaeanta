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
            <div style="margin-bottom: 3%;">
              <h3 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%;">SUB</h3>
              <div style="margin-top: 1%;">
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
            </div>
            <hr>
            <!-- 패션 정보 -->
            <div style="margin-bottom: 3%; margin-top: 1%">
              <h3 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin: 2%;">스타일</h3>
              <div class="d-flex" style="padding-left: 15%; padding-top: 1%">
                <span style="font-size: 1.2rem; font-family: ELAND_Choice_M;">#{{ imageDetail.style[0].style }}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                <span style="font-size: 1.2rem; font-family: ELAND_Choice_M;" v-if="imageDetail.style[0].subStyle !== null">#{{ imageDetail.style[0].subStyle }}</span>
              </div>
            </div>
            <hr>
            <div style="margin-top: 3%">
              <v-row>
                <v-col v-if="!isEmptyObject(imageDetail.outer[0])" cols="4">
                  <div style="padding-left: 2%; border-right:1px solid #DDDDDD;">
                    <h3 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%; margin-top: 1%; margin-bottom: 2%">아우터</h3>
                    <div>
                      <div align="left" v-if="imageDetail.outer[0].category">
                        <span :style="fashionInfoLabelStyle">의상 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.outer[0].category }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.outer[0].color">
                        <span :style="fashionInfoLabelStyle">색상 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.outer[0].color }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.outer[0].length">
                        <span :style="fashionInfoLabelStyle">기장 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.outer[0].length }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.outer[0].print !== undefined">
                        <div v-if="imageDetail.outer[0].print.length !== 0">
                          <span :style="fashionInfoLabelStyle">디자인 :</span>
                          <span v-for="design in imageDetail.outer[0].print" :key="design" style="font-size: 0.9rem; font-family: ELAND_Choice_M; margin-left: 2%;">{{ design }}</span>
                        </div>
                      </div>
                      <div align="left" v-if="imageDetail.outer[0].material">
                        <span :style="fashionInfoLabelStyle">소재 :</span>
                        <span v-for="material in imageDetail.outer[0].material" :key="material" style="font-size: 0.9rem; font-family: ELAND_Choice_M; margin-left: 2%;">{{ material }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.outer[0].fit">
                        <span :style="fashionInfoLabelStyle">핏 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.outer[0].fit }}</span>
                      </div>
                    </div>
                  </div>
                </v-col>
                <v-col v-if="!isEmptyObject(imageDetail.onepiece[0])" cols="4">
                  <div style="padding-left: 2%;">
                    <h3 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%; margin-top: 1%; margin-bottom: 2%;">원피스</h3>
                    <div >
                      <div align="left" v-if="imageDetail.onepiece[0].category">
                        <span :style="fashionInfoLabelStyle">의상 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.onepiece[0].category }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.onepiece[0].color">
                        <span :style="fashionInfoLabelStyle">색상 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.onepiece[0].color }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.onepiece[0].length">
                        <span :style="fashionInfoLabelStyle">기장 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.onepiece[0].length }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.onepiece[0].print !== undefined">
                        <div v-if="imageDetail.onepiece[0].print.length !== 0">
                          <span :style="fashionInfoLabelStyle">디자인 :</span>
                          <span v-for="design in imageDetail.onepiece[0].print" :key="design" style="font-size: 0.9rem; font-family: ELAND_Choice_M; margin-left: 2%">{{ design }}</span>
                        </div>
                      </div>
                      <div align="left" v-if="imageDetail.onepiece[0].neckLine">
                        <span :style="fashionInfoLabelStyle">넥라인 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.onepiece[0].neckLine }}</span>
                      </div>
                    </div>
                  </div>
                </v-col>
                <v-col v-if="!isEmptyObject(imageDetail.onepiece[0])" cols="4">
                  <div style="padding-left: 2%;">
                    <h3 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%; margin-top: 1%; margin-bottom: 2%">&nbsp;</h3>
                    <div >
                      <div align="left" v-if="imageDetail.onepiece[0].detail.length !== 0">
                        <span :style="fashionInfoLabelStyle">디테일 :</span>
                        <span v-for="detail in imageDetail.onepiece[0].detail" :key="detail" style="font-size: 0.9rem; font-family: ELAND_Choice_M; margin-left: 2%;">{{ detail }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.onepiece[0].sleeveLength">
                        <span :style="fashionInfoLabelStyle">소매 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.onepiece[0].sleeveLength }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.onepiece[0].material.length !== 0">
                        <span :style="fashionInfoLabelStyle">소재 :</span>
                        <span v-for="material in imageDetail.onepiece[0].material" :key="material" style="font-size: 0.9rem; font-family: ELAND_Choice_M; margin-left: 2%;">{{ material }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.onepiece[0].fit">
                        <span :style="fashionInfoLabelStyle">핏 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.onepiece[0].fit }}</span>
                      </div>
                    </div>
                  </div>
                </v-col>
                <v-col v-if="!isEmptyObject(imageDetail.top[0])" cols="4">
                  <div style="padding-left: 2%; border-right:1px solid #DDDDDD;">
                    <h3 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%; margin-top: 1%; margin-bottom: 2%">상의</h3>
                    <div>
                      <div align="left" v-if="imageDetail.top[0].category">
                        <span :style="fashionInfoLabelStyle">의상 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.top[0].category }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.top[0].color">
                        <span :style="fashionInfoLabelStyle">색상 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.top[0].color }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.top[0].sleeveLength">
                        <span :style="fashionInfoLabelStyle">기장 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.top[0].sleeveLength }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.top[0].print !== undefined">
                        <div v-if="imageDetail.top[0].print.length !== 0">
                          <span :style="fashionInfoLabelStyle">디자인 :</span>
                          <span v-for="design in imageDetail.top[0].print" :key="design" style="font-size: 0.9rem; font-family: ELAND_Choice_M; margin-left: 2%;">{{ design }}</span>
                        </div>  
                      </div>
                      <div align="left" v-if="imageDetail.top[0].neckLine">
                        <span :style="fashionInfoLabelStyle">넥라인 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.top[0].neckLine }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.top[0].fit">
                        <span :style="fashionInfoLabelStyle">핏 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.top[0].fit }}</span>
                      </div>
                    </div>
                  </div>               
                </v-col>
                <v-col v-if="!isEmptyObject(imageDetail.bottom[0])" cols="4">
                  <div style="padding-left: 2%; border-right:1px solid #DDDDDD;">
                    <h3 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin-left: 2%; margin-top: 1%; margin-bottom: 2%">하의</h3>
                    <div>
                      <div align="left" v-if="imageDetail.bottom[0].category">
                        <span :style="fashionInfoLabelStyle">의상 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.bottom[0].category }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.bottom[0].color">
                        <span :style="fashionInfoLabelStyle">색상 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.bottom[0].color }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.bottom[0].length">
                        <span :style="fashionInfoLabelStyle">기장 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.bottom[0].length }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.bottom[0].print !== undefined">
                        <div v-if="imageDetail.bottom[0].print.length != 0">
                          <span :style="fashionInfoLabelStyle">디자인 :</span>
                          <span v-for="design in imageDetail.bottom[0].print" :key="design" style="font-size: 0.9rem; font-family: ELAND_Choice_M; margin-left: 2%;">{{ design }}</span>
                        </div>
                      </div>
                      <div align="left" v-if="imageDetail.bottom[0].material">
                        <span :style="fashionInfoLabelStyle">소재 :</span>
                        <span v-for="material in imageDetail.bottom[0].material" :key="material" style="font-size: 0.9rem; font-family: ELAND_Choice_M; margin-left: 2%;">{{ material }}</span>
                      </div>
                      <div align="left" v-if="imageDetail.bottom[0].fit">
                        <span :style="fashionInfoLabelStyle">핏 :</span>
                        <span :style="fashionInfoStyle">{{ imageDetail.bottom[0].fit }}</span>
                      </div>
                    </div>
                  </div>
                </v-col>
              </v-row>
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
        marginLeft: '2%',
        fontSize: '0.9rem',
        fontFamily: 'ELAND_Choice_M',
      }
    },
    fashionInfoLabelStyle () {
      return {
        marginLeft: '6%',
        fontSize: '0.9rem',
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
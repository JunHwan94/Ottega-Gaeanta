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
              <h1 style="margin-top: 10%; font-family: 'Cafe24Ssurround'; color: #FBACCC;">상세보기 -> </h1>
            </div>
          </div>

          <!-- 코디 정보 -->
          <div id="infobook1" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem;"></div>
          <div id="infobook3" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem;"></div>
          <div id="infobook4" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem;"></div>
          <div id="infobook5" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem;"></div>
          <div id="infobook6" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem;"></div>
          <div id="infobook7" @click="goFlip" :style="flipCSS2" v-if="imageDetail" style="padding-top: 3rem;">
            <h2 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin: 2%;">스타일</h2>
            <div class="d-flex" style="padding-left: 10%;">
              <span style="font-size: 1.5rem;">#{{ imageDetail.style[0].style }}</span>&nbsp;&nbsp;&nbsp;&nbsp;
              <span style="font-size: 1.5rem;" v-if="imageDetail.style[0].subStyle !== null">#{{ imageDetail.style[0].subStyle }}</span>
            </div>
            <br>
            <div v-if="!isEmptyObject(imageDetail.outer[0])">
              <h2 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin: 2%;">아우터</h2>
              아우터 
              {{ imageDetail.outer[0].print[0] }}
            </div>
            <div v-if="!isEmptyObject(imageDetail.onepiece[0])">
              <h2 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin: 2%;">원피스</h2>
              원피스 {{ imageDetail.onepiece }}
            </div>
            <div v-if="!isEmptyObject(imageDetail.top[0])">
              <h2 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin: 2%;">상의</h2>
              상의 {{ imageDetail.top }}
            </div>
            <div v-if="!isEmptyObject(imageDetail.bottom[0])">
              <h2 style="color: #000000; text-align: left; font-family: Cafe24Ssurround; margin: 2%;">하의</h2>
              하의 {{ imageDetail.bottom }}
            </div>
          </div>

          <v-card-actions style="height: 5vh">
            <v-spacer></v-spacer>
            <v-btn
              color="secondary"
              text
              @click="showStyleInfo({showSearchDetail}); variableShowInitialize();"
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
      pages: ['@/assets/1.jpg',
              '@/assets/2.jpg',
              '@/assets/3.jpg',
              ],
    }
  },
  computed: {
    ...mapState([
      'showSearchDetail',
      'searchDetailImageURL',

      // 이 친구가 해당 사진 정보 담고 있습니다.
      'imageDetail'
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
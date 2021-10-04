<template>
  <div class="film-container" align="center">
    <div class="title">
      <h2>보이는 가이드라인과 같이 정면을 향하여<br>상의 및 하의가 잘 보일 수 있도록 해주시기 바랍니다</h2>
    </div>
    <v-row class="menu-container" justify="center">
      <v-col lg=3></v-col>
      <!-- <v-col lg=3 align="right">
        <div class="card" align="center">
          <p>아래 예시와 같이 화면에 상의 및 하의가</p>
          <img :src="mainImageUrl" />
        </div>
      </v-col> -->
      <v-col  align="left">
        <div class="card" style="width: 100%; height: 95%; background-color: white; box-shadow: black;" align="center">
          <evaluation-camera></evaluation-camera>
        </div>
      </v-col>
      <v-col lg=3></v-col>
    </v-row>
    
    <v-row justify="center">
      <div class="capture-btn" id="capture-btn" @click="capture()">
        <h2>{{sec}} 초 뒤 촬용😊</h2>
      </div>
      <div style="width=2%;"></div>
      <div class="capture-btn" id="retry-btn" @click="retry()" style="display: none;">
        <h2>다시 찍기😊</h2>
      </div>
      <!-- <div class="capture-btn" style="color: white" @click="post()"> -->
      <div class="capture-btn" style="color: white">  
        <h2>의상 분석😊</h2>
      </div>
    </v-row>
  </div>
</template>

<script>
  import EvaluationCamera from '@/components/evaluation/EvaluationCamera.vue'
  export default {
    data: () => ({
      mainImageUrl: require('@/assets/evaluation-model.png'),
      sec : 5,
    }),
    components: {
      EvaluationCamera,
    },
    methods: {
      playVideo() {
        this.$children[0].$vnode.componentInstance.toggleStream()
      },
      post() {
        this.$children[0].$vnode.componentInstance.post()
      },
      capture() {
        let timer = setInterval(() => {
          this.sec -= 1
          if(this.sec == 0) {
            this.$children[0].$vnode.componentInstance.cvtGray()
            document.getElementById('capture-btn').style.display = 'none'
            document.getElementById('retry-btn').style.display = ''
            clearTimeout(timer)
          }
        }, 1000)
      },
      retry() {
        this.sec = 5
        this.$children[0].$vnode.componentInstance.retryCamera()
        document.getElementById('capture-btn').style.display = ''
        document.getElementById('retry-btn').style.display = 'none'
      }
    },
    mounted() {
      this.playVideo()
    }
  }
</script>

<style scoped>
.film-container {
  padding-top: 4rem;
  height: 100%;
  width: 100vw;
  background: linear-gradient(to bottom right, #FBACCC, #F1D1D0, white);
}
.title {
  margin-top: 10vh;
  margin-bottom: 5vh;
}
.content-area {
  width: 100%;
  height: 70%;
}
img {
  width: 200px;
  height: 200px;
}
.card {
  display: inline-block;
  width: 300px;
  height: 500px;
  border: 3px solid rgb(0, 0, 0);
  border-radius: 5%;
  margin: 15px 15px;
  padding: 10px 0px;
}
p, h2 {
  font-family: Cafe24Ssurround;
}
.capture-btn {
  border: 2px solid rgb(0, 0, 0);
  padding: 10px;
  width: 400px;
  border-radius: 25px;
  background-color: #F875AA;
  cursor: pointer;
  margin: 0 1%;
  margin-bottom: 2%;
}
</style>
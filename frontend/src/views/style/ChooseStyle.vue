<template>
  <div class="main-container">
    <swal-alert></swal-alert>
    <div class="explain-area">
      <h2>✔ 선호하는 스타일을 3가지 선택하세요</h2>
      <p class="explain-detail">회원님이 좋아하실만한 스타일을 더 많이 추천해드릴 수 있습니다.</p>
    </div>
    <div class="container">
      <div v-for="(image ,i) in images1" :key="i" class="box" @click="[showStyleDetailModal(i)]">
        <div class="select">
          <!-- <span>♥♥</span> -->
          <img :src="image" style="width:310px; height: 260px;"/>
          <div class="heart-area"></div>
        </div>
      </div>
    </div>
    <div class="container">
      <div v-for="(image, i) in images2" :key="i" class="box" @click="[showStyleDetailModal(i + 5)]">
        <div class="select" style="position: relative;">
          <!-- <h1>♥</h1> -->
          <img :src="image" style="width:310px; height: 300px;"/>
          <div class="heart-area"></div>
          <!-- <div style="position: absolute; top: 50%; left: 115px; font-size: 50px; color: #F4F9F9;">♥</div> -->
        </div>
      </div>
    </div>
    <!-- <div class="divider"></div> -->
    <div align="center">
      <div class="btn" @click="confirm()">스타일 확정</div>
    </div>
    <!-- 스타일 확정 버튼이 밑에 박혀 있어서 좀 띄워주기 위한 빈공간 -->
    <div style="height: 100px;"></div>
    <choose-style-detail v-if="show" @close="invisibleModal" @like-style="likeStyle"></choose-style-detail>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import ChooseStyleDetail from '../../components/chooseStyle/ChooseStyleDetail.vue'
  import SwalAlert from '@/components/SwalAlert'
  export default {
    data: () => ({
      images1: [
        require('@/assets/chooseStyle/1-traditional.jpg'),
        require('@/assets/chooseStyle/2-manish.jpg'),
        require('@/assets/chooseStyle/3-feminine.jpg'),
        require('@/assets/chooseStyle/4-ethnic.jpg'),
        require('@/assets/chooseStyle/5-contemporary.jpg'),
      ],
      images2: [
        require('@/assets/chooseStyle/6-natural.jpg'),
        require('@/assets/chooseStyle/7-gender.jpg'),
        require('@/assets/chooseStyle/8-sporty.jpg'),
        require('@/assets/chooseStyle/9-subculture.jpg'),
        require('@/assets/chooseStyle/10-casual.jpg'),
      ],
      imageDepth: [
        require('@/assets/chooseStyle/1-traditional-map.png'),
        require('@/assets/chooseStyle/2-manish-map.png'),
        require('@/assets/chooseStyle/3-feminine-map.png'),
        require('@/assets/chooseStyle/4-ethnic-map.png'),
        require('@/assets/chooseStyle/test.png'),
        require('@/assets/chooseStyle/6-natural-map.png'),
        require('@/assets/chooseStyle/7-gender-map.png'),
        require('@/assets/chooseStyle/8-sporty-map.png'),
        require('@/assets/chooseStyle/9-subculture-map.png'),
        require('@/assets/chooseStyle/10-casual-map.png'),
      ],
      style: [
        '트레디셔널',
        '매니시',
        '페미닌',
        '에스닉',
        '컨템포러리',
        '내추럴',
        '젠더프루이드',
        '스포티',
        '서브컬처',
        '캐주얼',
      ],
      show: false,
      visibleFirstStyle: true,
      checkList: [false, false, false, false, false, false, false, false, false, false],
    }),
    computed: {
      ...mapGetters(["getSelectedUserStyle"]),
    },
    components: {
      ChooseStyleDetail,
      SwalAlert
    },
    methods: {
      invisibleModal () {
        this.show = false
      },
      showStyleDetailModal(i) {
        if (this.show) {
          this.show = false
          return
        }
        const select = document.getElementsByClassName('select')[i]
        const area = document.getElementsByClassName('box')[i]
        const heart = document.getElementsByClassName('heart-area')[i]
        
        if (this.checkList[i]) {
          this.checkList[i] = false
          select.classList.remove('check')
          area.classList.remove('back')
          heart.classList.remove('heart')
          return
        }
        this.$store.commit('SAVE_STYLE_IMAGE', i < 5 ? this.images1[i] : this.images2[i-5])
        this.$store.commit('SAVE_STYLE_DEPTH_IMAGE', this.imageDepth[i])
        this.$store.commit('SAVE_STYLE_INDEX', i)
        this.show = true
      },
      confirm() {
        let checkCount = 0
        const selectedUserStyle = []
        for (let i = 0; i < this.checkList.length; i++) {
          if (this.checkList[i]) {
            selectedUserStyle.push(this.style[i])
            checkCount++
          }
        }
        if (checkCount != 3) {
          const text = checkCount < 3 ? '선호 스타일을 <br>3개 선택해주세요!' : '선호 스타일을 <br>3개만 선택해주세요!'
          this.$children[0].$vnode.componentInstance.swalAlert('error', text)
          return
        }
        
        this.$store.commit('SAVE_SELECTED_USER_STYLE', selectedUserStyle)
        this.$router.push('/searchResult')
      },
      likeStyle (i) { // modal에서 좋아요 눌렀을 때 처리
        this.checkList[i] = true
        const select = document.getElementsByClassName('select')[i]
        const area = document.getElementsByClassName('box')[i]
        const heart = document.getElementsByClassName('heart-area')[i]
        select.classList.add('check')
        area.classList.add('back')
        heart.classList.add('heart')
      }
    },
    mounted() {
      if (this.getSelectedUserStyle != null) {
        for (let i = 0; i < this.getSelectedUserStyle.length; i++) {
          const index = this.style.indexOf(this.getSelectedUserStyle[i])
          this.checkList[index] = true
          const select = document.getElementsByClassName('select')[index]
          const area = document.getElementsByClassName('box')[index]
          const heart = document.getElementsByClassName('heart-area')[index]
          select.classList.add('check')
          area.classList.add('back')
          heart.classList.add('heart')
        }
      }
      
    }
  }
</script>

<style scoped>
.main-container {
  padding-top: 4rem;
  height: 100%;
  width: 100vw;
  background: linear-gradient(to bottom right, #FBACCC, #F1D1D0, white);
  font-family: Binggrae-Bold;
}
.container {
  display: flex;
  width: 100%;
  box-sizing: border-box;
}
.divider {
  margin-top: 50px;
}
.box {
  flex: 1;
  overflow: hidden;
  transition: .5s;
  margin: 0 2%;
  box-shadow: 0 20px 30px rgba(0, 0, 0, .1);
  line-height: 0;
  height: 260px;
  cursor: pointer;
  border-radius: 15px;
  border: 2px solid hotpink;
  position: relative;
}
.select {
  position: absolute;
  width: 100%;
  height: 100%;
  z-index: 1;
  background-color: black;
}
.check {
  background-color: black;
  opacity: 0.5;
}
.check > h1 { 
  color: red; 
  line-height: 300px;
}
.box>img {
  width: 100%;
  object-fit: cover;
  transition: .5s;
  height: 40vh;
}
.box:hover {
  flex: 2%;
}
F .box:hover>img {
  width: 100%;
  height: 100%;
}
.explain-area {
  margin: 60px;
  margin-bottom: 20px;
}
.explain-detail {
  margin-left: 15px;
  font-size: 2vh;
}
.btn {
  border: 2px solid #F875AA;;
  color: #F875AA;
  padding: 10px;
  width: 400px;
  border-radius: 25px;
  background-color: #F4F9F9;
  cursor: pointer;
  margin-top: 5vh;
  font-family: Cafe24Ssurround;
}
.btn:hover {
  color:#F4F9F9;
  background-color: #F875AA;
}
.back {
  background: white;
  animation-name: backdiv;
  animation-duration: 1s; 
  animation-iteration-count: infinite;
}
.heart {
  position: absolute;
  margin: auto;
  top: -50px;
  right: 0;
  bottom: 0;
  left: 0;
  background-color: pink;
  height: 50px;
  width: 50px;
  transform: rotate(-45deg);
  animation-name: beat;
  animation-duration: 1s;
  animation-iteration-count: infinite;
  z-index: 999;
}
.heart:after {
  background-color: pink;
  content: "";
  border-radius: 50%;
  position: absolute;
  width: 50px;
  height: 50px;
  top: 0px;
  left: 25px;
}
.heart:before {
  background-color: pink;
  content: "";
  border-radius: 50%;
  position: absolute;
  width: 50px;
  height: 50px;
  top: -25px;
  left: 0px;
}
@keyframes backdiv {
  50% {
    background: #ffe6f2;
  }
}
@keyframes beat {
  0% {
    transform: scale(1) rotate(-45deg);
  }
  50% {
    transform: scale(0.6) rotate(-45deg);
  }
}
</style>
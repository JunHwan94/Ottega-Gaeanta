<template>
  <div class="main-container">
    <div class="explain-area">
      <h1>✔ 선호하는 스타일을 3가지 선택하세요</h1>
      <p class="explain-detail">회원님이 좋아하실만한 스타일을 더 많이 추천해드릴 수 있습니다.</p>
    </div>
    <div class="container">
      <div v-for="(image ,i) in images1" :key="i" class="box" @click="[boxClick(i), showStyleDetailModal(i)]">
        <div class="select">
          <!-- <span>♥♥</span> -->
          <img :src="image" style="width:310px; height: 300px;"/>
        </div>
      </div>
    </div>
    <div class="container">
      <div v-for="(image, i) in images2" :key="i" class="box" @click="[boxClick(i + 5), showStyleDetailModal(i + 5)]">
        <div class="select">
          <!-- <h1>♥</h1> -->
          <img :src="image" style="width:310px; height: 300px;"/>
        </div>
      </div>
    </div>
    <!-- <div class="divider"></div> -->
    <div align="center">
      <div class="btn" @click="confirm()">스타일 확정</div>
      <div class="btn" @click="toggle()">토글</div>
    </div>
    <choose-style-detail v-if="show"></choose-style-detail>
  </div>
</template>

<script>
  import ChooseStyleDetail from '../../components/chooseStyle/ChooseStyleDetail.vue'
  export default {
    data: () => ({
      images1: [
        require('@/assets/chooseStyle/1-traditional.jpg'),
        require('@/assets/chooseStyle/2-manish.jpg'),
        require('@/assets/chooseStyle/p1.png'),
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
        require('@/assets/chooseStyle/p1map.png'),
        require('@/assets/chooseStyle/test.png'),
        require('@/assets/chooseStyle/test.png'),
        require('@/assets/chooseStyle/p1map.png'),
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
        '서브컬쳐',
        '캐주얼',
      ],
      show: false,
      visibleFirstStyle: true,
      checkList: [false, false, false, false, false],
    }),
    components: {
      ChooseStyleDetail
    },
    methods: {
      toggle() {
        this.show = !this.show
      },
      showStyleDetailModal(i) {
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
        if (checkCount < 3) {
          alert('선호 스타일을 세 가지 선택해주세요.')
          return
        }
        this.$store.commit('SAVE_SELECTED_USER_STYLE', selectedUserStyle)

        // 스타일 세 개 이상 선택 했는지 확인

        // 선호 스타일 리스트 한 번 보여주고 다시 물어보기 ?

        // 이동
        this.$router.push('/searchResult')
      },
      boxClick (i) {
        this.checkList[i] = !this.checkList[i]
        const select = document.getElementsByClassName('select')[i]
        if (this.checkList[i]) {
          select.classList.add('check')
          console.log(i)
          // this.$store.commit('SAVE_STYLE_IMAGE', i < 5 ? this.images1[i] : this.images2[i-5])
          // this.$store.commit('SAVE_STYLE_DEPTH_IMAGE', this.imageDepth[i])
        } else {
          select.classList.remove('check')
        }
      }
    },
    mounted() {
      // const frameWidth = 310, frameHeight = 300;
      // const size = 10
      // console.log(this.img)
      // const apps = []
      // for (let i = 0; i < size; i++) {
      //   apps[i] = new PIXI.Application({width: frameWidth, height: frameHeight})
      // }

      // /* PIXI 객체 생성 및 적용 */
      // const frames = document.getElementsByClassName('box')
      // for (let i = 0; i < frames.length; i++) {
      //   frames[i].appendChild(apps[i].view)
      // }
      // const images = []
      // for (let i = 0; i < size; i++) {
      //   images[i] = new PIXI.Sprite.from(this.images[i])
      //   images[i].width = frameWidth
      //   images[i].height = frameHeight
      //   apps[i].stage.addChild(images[i])
      // }

      // /* PIXI 이미지 외곡 설정 및 적용 */
      // const depthMaps = []
      // const displacementFilters = []
      // for (let i = 0; i < size; i++) {
      //   depthMaps[i] = new PIXI.Sprite.from(require('@/assets/chooseStyle/p1map.png'));
      //   depthMaps[i].width = frameWidth
      //   depthMaps[i].height = frameHeight
      //   apps[i].stage.addChild(depthMaps[i])
      //   displacementFilters[i] = new PIXI.filters.DisplacementFilter(depthMaps[i])
      //   console.log(apps[i])
      //   apps[i].stage.filters = [displacementFilters[i]]
      // }

      // // 마우스 이동 이벤트 지정
      // for (let i = 0; i < frames.length; i++) {
      //   frames[i].onmousemove = function (e) {
      //     displacementFilters[i].scale.x = (window.innerWidth / 2 - e.clientX) / 25 ;
      //     displacementFilters[i].scale.y = (window.innerHeight / 2 - e.clientY) / 20;
      //   }
      // }
    },
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
    /* padding: 4% 2%; */
    box-sizing: border-box;
    /* height: 100vh; */
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
    height: 300px;
    cursor: pointer;
    border-radius: 15px;
    border: 2px solid black;
    /* background: black; */
    position: relative;
    /* box-shadow: 0 20px 30px rgba(0,0,0,.1); */
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
    /* height: calc(100% - 10vh); */
    /* height: 300px; */
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
    /* margin-top: 15px; */
    font-size: 3vh;
  }
  .btn {
  border: 2px solid black;
  padding: 10px;
  width: 400px;
  border-radius: 25px;
  background-color: #F875AA;
  cursor: pointer;
  margin-top: 5vh;
  font-family: Cafe24Ssurround;
}
</style>
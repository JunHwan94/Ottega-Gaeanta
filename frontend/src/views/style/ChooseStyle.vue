<template>
  <div class="main-container">
    <div class="explain-area">
      <h1>✔ 선호하는 스타일을 3가지 선택하세요</h1>
      <p class="explain-detail">회원님이 좋아하실만한 스타일이나 색감을 더 많이 추천해드릴 수 있습니다.</p>
    </div>
    <div class="container">
      <div v-for="i in 5" :key="i" class="box" @click="boxClick(i - 1)">
        <div class="select">
          <!-- <h1>♥</h1> -->
        </div>
      </div>
      <!-- <div class="box">
        <div class="select">
        </div>
      </div>
      <div class="box">
        <div class="select">
        </div>
      </div>
      <div class="box">
        <div class="select">
        </div>
      </div>
      <div class="box">
        <div class="select">
        </div>
      </div> -->
    </div>
    <div class="divider"></div>
    <div align="center">
      <div class="btn" @click="confirm()">dasdad</div>
    </div>
  </div>
</template>

<script>
  export default {
    data: () => ({
      images: [
        require('@/assets/chooseStyle/sample2.jpg'),
        require('@/assets/chooseStyle/sample3.jpg'),
        require('@/assets/chooseStyle/sample4.jpg'),
        require('@/assets/chooseStyle/sample5.jpg'),
        require('@/assets/chooseStyle/sample6.jpg'),
      ],
      checkList: [false, false, false, false, false],
    }),
    methods: {
      confirm() {
        alert(this.checkList)
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
        } else {
          select.classList.remove('check')
        }
        
      }
    },
    mounted() {
      const frameWidth = 310, frameHeight = 300;
      const size = 5
      // let app = new PIXI.Application({
      //   width: frameWidth,
      //   height: frameHeight
      // });
      console.log(this.img)
      const apps = []
      for (let i = 0; i < size; i++) {
        apps[i] = new PIXI.Application({width: frameWidth, height: frameHeight})
      }

      /* PIXI 객체 생성 및 적용 */
      // console.log(app.view.style.position = 'relative')
      // document.querySelector('.box').appendChild(app.view); // html tag 한 개 나옴
      const frames = document.getElementsByClassName('box')
      for (let i = 0; i < frames.length; i++) {
        frames[i].appendChild(apps[i].view)
        console.log('ddd')
      }
      console.log('1')
      const images = []
      for (let i = 0; i < size; i++) {
        images[i] = new PIXI.Sprite.from(this.images[i])
        images[i].width = frameWidth
        images[i].height = frameHeight
        apps[i].stage.addChild(images[i])
      }
      console.log('2')
      // let img = new PIXI.Sprite.from(require('@/assets/sample2.jpg'));
      // img.width = frameWidth;
      // img.height = frameHeight;
      // app.stage.addChild(img);

      /* PIXI 이미지 외곡 설정 및 적용 */
      const depthMaps = []
      const displacementFilters = []
      for (let i = 0; i < size; i++) {
        depthMaps[i] = new PIXI.Sprite.from(require('@/assets/map3.jpg'));
        depthMaps[i].width = frameWidth
        depthMaps[i].height = frameHeight
        console.log('2-1')
        apps[i].stage.addChild(depthMaps[i])
        console.log('2-2')
        displacementFilters[i] = new PIXI.filters.DisplacementFilter(depthMaps[i])
        console.log('2-3')
        console.log(apps[i])
        apps[i].stage.filters = [displacementFilters[i]]
      }
      console.log('3')
      for (let i = 0; i < frames.length; i++) {
        frames[i].onmousemove = function (e) {
          displacementFilters[i].scale.x = (window.innerWidth / 2 - e.clientX) / 20;
          displacementFilters[i].scale.y = (window.innerHeight / 2 - e.clientY) / 20;
        }
      }
      console.log('4')
      // let depthMap = new PIXI.Sprite.from(require('@/assets/map3.jpg'));
      // depthMap.width = frameWidth;
      // depthMap.height = frameHeight;
      // app.stage.addChild(depthMap);
      // let displacementFilter = new PIXI.filters.DisplacementFilter(depthMap);
      // app.stage.filters = [displacementFilter];

      /* PIXI 이미지 마우스 이벤트 지정 */
      // let control = document.querySelector('.box')
      // control.onmousemove = function (e) {
      //   displacementFilter.scale.x = (window.innerWidth / 2 - e.clientX) / 20;
      //   displacementFilter.scale.y = (window.innerHeight / 2 - e.clientY) / 20;
      // };
    },
  }
</script>

<style scoped>
  .main-container {
    padding-top: 4rem;
    height: 100vh;
    width: 100vw;
    background: linear-gradient(to bottom right, skyblue, white);
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
    height: 100%;
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
  }
  .check {
    background: black;
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
    margin: 100px;
  }

  .explain-detail {
    margin-left: 15px;
    margin-top: 15px;
    font-size: 3vh;
  }
  .btn {
  border: 2px solid black;
  padding: 10px;
  width: 400px;
  border-radius: 25px;
  background-color: violet;
  cursor: pointer;
  margin-top: 5vh;
}
</style>
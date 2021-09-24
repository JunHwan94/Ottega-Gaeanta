<template>
  <div class="main-container">
    <div class="explain-area">
      <h1>✔ 선호하는 스타일을 3가지 선택하세요</h1>
      <p class="explain-detail">회원님이 좋아하실만한 스타일이나 색감을 더 많이 추천해드릴 수 있습니다.</p>
    </div>
    <div class="container">
      <div class="box" align="center">
        <img :src="img">
      </div>
      <div class="box">
        <img :src="img2">
      </div>
      <div class="box">
        <img src="https://source.unsplash.com/1000x804">
      </div>
      <div class="box">
        <img src="https://source.unsplash.com/1000x806">
      </div>
      <div class="box">
        <img src="https://source.unsplash.com/1000x806">
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data: () => ({
      img: require('@/assets/sample2.jpg'),
      img2: require('@/assets/main.png'),
    }),

    mounted() {
      let app = new PIXI.Application({width: 250, height: 400});
      document.querySelector('.main-container').appendChild(app.view);
      let img = new PIXI.Sprite.from(require('@/assets/sample2.jpg'));
      img.width = 250;
      img.height = 400;
      app.stage.addChild(img);

      let depthMap = new PIXI.Sprite.from(require('@/assets/map3.jpg'));
      depthMap.width = 250;
      depthMap.height = 400;
      app.stage.addChild(depthMap);

      let displacementFilter = new PIXI.filters.DisplacementFilter(depthMap);
      app.stage.filters = [displacementFilter];

      let control = document.querySelector('.main-container')
      control.onmousemove = function(e) {
          displacementFilter.scale.x = (window.innerWidth / 2 - e.clientX) / 20;
          displacementFilter.scale.y = (window.innerHeight / 2 - e.clientY) / 20;
      };
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

  .box {
    flex: 1;
    overflow: hidden;
    transition: .5s;
    margin: 0 2%;
    box-shadow: 0 20px 30px rgba(0, 0, 0, .1);
    line-height: 0;
    height: 100%;
    cursor: pointer;
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
    flex: 5%;
  }
F
  .box:hover>img {
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
</style>
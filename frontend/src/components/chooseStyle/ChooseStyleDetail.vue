<template>
  <div class="container" align="center">
    <div class="image-area">
      <!-- <img :src="image" /> -->
    </div>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  export default {
    name: 'ChooseStyleDetail',
    data: () => ({
      image: require('@/assets/chooseStyle/p1.png'),
      depthImage: require('@/assets/chooseStyle/p1map.png'),
      depthImage2: require('@/assets/chooseStyle/map3.jpg')
    }),
    computed: {
      ...mapGetters(['getStyleImage', 'getStyleDepthImage']),
    },
    mounted() {
      alert('마운트 됨')
      let app = new PIXI.Application({width: 500, height:500});
      const frame = document.getElementsByClassName('image-area')[0]
      console.log(frame)
      frame.appendChild(app.view)
      const img = new PIXI.Sprite.from(this.getStyleImage);
      img.width = 500
      img.height = 500

      app.stage.addChild(img);
      const depthMap = new PIXI.Sprite.from(this.getStyleDepthImage);
      depthMap.width = 500
      depthMap.height = 500
      app.stage.addChild(depthMap);

      const displacementFilter = new PIXI.filters.DisplacementFilter(depthMap);
      app.stage.filters = [displacementFilter];

      frame.onmousemove = function(e) {
        displacementFilter.scale.x = (500 / 2 - e.clientX) / 30;
        displacementFilter.scale.y = (500 / 2 - e.clientY) / 50;
      };
    }
  }
</script>

<style scoped>
.image-area {
  width: 40vw;
  height: 60vh;
  background-color: white;
  border-radius: 10px;
  position: absolute;
  z-index: 30;
  top: 20%;
  left: 30%;
  border: 2px solid #F875AA;
  padding: 15px;
  font-family: Cafe24Ssurround; /* Binggrae-Bold */
}
.image-area {
  /* width: 800px;
  height: 800px; */

}
</style>
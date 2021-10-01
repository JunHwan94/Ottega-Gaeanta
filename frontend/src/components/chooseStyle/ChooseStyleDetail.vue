<template>
  <div class="container" align="center">
    <div class="image-area">
      <span style="font-size: 2.5vh;">{{data[getStyleIndex].title}}</span>
      <span style="float: right; cursor: pointer; font-size: 2.5vh;" @click="close()">X</span>
      <div class="divider"></div>
      <div class="pixi"></div>
      <div align="left" style="padding: 10px 80px;">
        <div v-for="tag in data[getStyleIndex].hashtag" :key="tag" style="color: blue; display:inline-block; margin-right: 50px;">
          {{tag}}
        </div>
        <div style="margin-top: 10px;">
          {{data[getStyleIndex].content}}
        </div>
        <div style="margin-top: 10px; padding-top: 30px;">
          <h2 class="mb-5">하위 스타일에는 어떤게 있을까요!?</h2>
          <div v-for="style in data[getStyleIndex].subStyle" :key="style" style="color: red; display:inline-block; margin-right: 50px;">
            {{style}}
          </div>
        </div>
        <div style="margin-top: 10px; padding-top: 30px;">
          <h2 class="mb-5" v-html="data[getStyleIndex].end"></h2>
          <div  align="center">
            <div class="btn">{{data[getStyleIndex].style}} 선택하기</div>
          </div>
          
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  export default {
    name: 'ChooseStyleDetail',
    data: () => ({
      data: [
        {
          title: '트레디셔널 : 올드한 느낌을 현대에 맞게 재해석하다.',
          hashtag: ['# 전통적인', '# 체크', '# 고풍스러운'],
          content: '트레디셔널 스타일은 전통에 근거한 고풍스러운 스타일을 뜻합니다. 전통은 넓은 의미로는 과거부터 전해오는 문화유산이기 때문에 자칫 패션에 적용하면 촌스러울 수 있지만 트레디셔널 스타일은 전통의 감성을 현대에서 풀어낸 스타일이라고 할 수 있겠습니다. ',
          subStyle: ['클래식','프레피'],
          end: '잠깐! 혹시 <span style="color:red;">체크무늬</span>를 좋아하시나요? 그렇다면!!!!!',
          style: '트레디셔널'
        },
      ]
    }),
    computed: {
      ...mapGetters(['getStyleImage', 'getStyleDepthImage', 'getStyleIndex']),
    },
    mounted() {
      // alert('마운트 됨')
      let app = new PIXI.Application({width: 500, height:500});
      
      const frame = document.getElementsByClassName('pixi')[0]
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
        displacementFilter.scale.x = (500 / 2 - e.clientX) / 50;
        displacementFilter.scale.y = (500 / 2 - e.clientY) / 50;
      };
    }
  }
</script>

<style scoped>
.image-area {
  width: 40vw;
  height: 70vh;
  background-color: white;
  border-radius: 10px;
  position: absolute;
  z-index: 30;
  top: 12%;
  left: 30%;
  border: 4px solid #F875AA;
  padding: 15px;
  padding-top: 30px;
  font-family: Cafe24Ssurround; /* Binggrae-Bold */
  overflow: scroll;
  overflow-x: hidden;
}
.divider {
  height: 2px;
  width: 80%;
  margin: 20px 0px;
  margin-top: 10px;
  background-color:  #FBACCC;
}
.btn {
  width: 300px;
  height: 80px;
  line-height: 80px;
  font-size: 2.5vh;
  background-color: #F875AA;
  border-radius: 10px;
  margin: 0px 10px;
  color: #F4F9F9;
  cursor: pointer;
  text-align: center;
}
</style>
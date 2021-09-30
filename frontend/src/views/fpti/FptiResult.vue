<template>
  <div id="div-container">
    <div align="center" style="margin-top: 5rem;">
      <v-card style="width: 30rem;">
        <h1 style="text-align: left;">패피티아이 진단 결과</h1>
        <h1 style="text-align: right; color: #F875AA">당신은?</h1>
        <v-img :src="result.iconUrl"></v-img>
        <br>
        <div style="height: 7rem; vertical-align: middle; background-color: #333333">
          <div class="d-flex pt-3" style="justify-content: center; display: inline-block;">
            <span style="color: white; text-align: center; font-size: 1rem;">Your</span>
            &nbsp;&nbsp;&nbsp;
            <span style="color: white; text-align: center;">St.</span>
          </div>
          <h1 style="color: white; text-align: center; text-decoration: underline;">{{result.fptiName}}</h1>
        </div>
        <br>
        <div class="d-flex">
          <div v-for="tag in result.hashtag" :key="tag">
            <span style="color: #FBACCC; margin-left: 20px; font-family: Cafe24Ssurround;">{{ tag }}</span>
          </div>
        </div>
        <br>
        <h2>{{result.title}}</h2>
        <div class="mx-3 mt-3">
          <span style="font-size: 1.2rem;">{{result.desc}}</span >
        </div>
        <br>
        <h2 style="color: #F875AA; text-align: center; font-family: Cafe24Ssurround;">{{ result.comment }}</h2>
        <br>
        <div>
          <v-row style="background-color: #F1D1D0; height: 200px;">
            <v-col v-for="(image, idx) in result.bgImgUrl" :key="idx" cols="4">
              <v-avatar size="7rem" :style="'margin-top:'+paddingArray[idx]">
                <img :src="image" style="border: 5px solid #FBACCC;">
              </v-avatar>
            </v-col>
          </v-row>
        </div>
        <div style="height: 200px;"></div>
      </v-card>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      result: {
        "typeno": 1,
        "fptiName":"트레디셔널",
        "title" : "지성미 있는 트레디셔널 엘리트", 
        "desc" : "'전통의','전통에 근거한','고풍스러운'이라는 뜻을 가지며 트랜드룩(Trad look)이라는 약칭으로도  불려요. 전통이란 넓은 의미로는 과거로부터 전해 오는 문화유산이며,사회, 민족 또한 문화 영역에서 과거에 형성되어 미래까지영향을 끼칠 수 있는 모든  행동, 관습, 양식, 태도 등을 말해요", 
        "comment" : "혹시 체크무늬를 좋아하시나요? ", 
        "iconUrl" : 'http://nitpickimg.cafe24.com/psy/5/result_main/INFP.jpg', 
        "bgImgUrl" : [
          "https://j5b206.s3.ap-northeast-2.amazonaws.com/클래식/GramMeterGroove_033_59.jpg", 
          "https://j5b206.s3.ap-northeast-2.amazonaws.com/프레피/20190315(샘플,중국)-최정임님-sk2271k93(3)-바비제이(샘플,프로썸SK)0315-모델-IMG_6541.jpg", 
          "https://j5b206.s3.ap-northeast-2.amazonaws.com/프레피/20180309(대행)13-jk1004(5931)IMG_0006.jpg"], 
        "hashtag" : ["#고전의", "#늙은이", "#지성미"]
      },
      paddingArray: ['10%','40%','15%'],
    }
  }
}
</script>

<style>

</style>
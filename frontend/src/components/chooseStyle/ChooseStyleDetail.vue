<template>
  <div class="container" align="center">
    <div id="back"></div>
    <div id="heart"></div>
    <div class="image-area modal-container">
      <span style="font-size: 2.5vh;">{{data[getStyleIndex].title}}</span>
      <span style="float: right; cursor: pointer; font-size: 2.5vh;" @click="close()">X</span>
      <div class="divider"></div>
      <div class="pixi"></div>
      <div align="left" style="padding: 10px 80px;">
        <div v-for="tag in data[getStyleIndex].hashtag" :key="tag" style="color: blue; display:inline-block; margin-right: 50px; font-family:Cafe24Ssurround;">
          {{tag}}
        </div>
        <div style="margin-top: 10px;" class="text-content">
          {{data[getStyleIndex].content}}
        </div>
        <div style="margin-top: 10px; padding-top: 30px;">
          <h2 class="mb-5">하위 스타일에는 어떤게 있을까요!?</h2>
          <div align="center" v-for="(style, index) in data[getStyleIndex].subStyle" :key="style" style="color: red; display:inline-block; margin-right: 50px;">
            <img :src="data[getStyleIndex].subStyleImage[index]" style="width: 100px; height: 100px; border-radius: 50px;"/><br>
            <span style="font-family: ELAND_Choice_M;">{{style}}</span>
          </div>
        </div>
        <div style="margin-top: 10px; padding-top: 30px;">
          <h2 class="mb-5" v-html="data[getStyleIndex].end"></h2>
          <div  align="center">
            <div class="btn" @click="like(getStyleIndex)">{{data[getStyleIndex].style}} 선택하기</div>
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
          style: '트레디셔널',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/클래식/GramMeterGroove_033_59.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/프레피/1 (24783).JPG',
          ]
        },
        {
          title: '매니시 : 신사복 디자인을 여성스러운 감각으로 도입하다.',
          hashtag: ['# 남성적', '# 단정한', '# 세미 정장'],
          content: '매니시 스타일은 보통 블라우스나 셔츠 & 블레이저 등 단정한 세미 정장 위주의 스타일입니다. 담백하고 불편함 없는, 익숙한 듯한 담담한 태도를 드러내는 소년 같은 소녀 스타일을 연출할 수 있습니다.',
          subStyle: ['매니시','톰보이'],
          end: '<span style="color:red;">단정하고 깔끔</span>한 스타일을 선호하신다면 추천합니다!',
          style: '매니시',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/매니시/jk523-jk523-s_10.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/톰보이/2020_04 촬영원본-반-리-나스OK-3-(1936)-d12.JPG'
          ]
        },
        {
          title: '페미닌 : 시대를 반영한 우아하고 여성스러운 스타일',
          hashtag: ['# 로맨틱', '# 섹시', '# 드레스'],
          content: '페미닌은 한 마디로 말해 여성만이 소화할 수 있는 일체형 드레스, 스커트 등의 스타일입니다. 페미닌, 로맨틱, 섹시 등의 하위 스타일이 다양하게 존재하기 때문에 상황에 맞게 연출이 가능한 스타일입니다.',
          subStyle: ['페미닌','로맨틱', '섹시'],
          end: '잠깐! 혹시 <span style="color:red;">여성스러운</span> 스타일을 좋아하시나요?',
          style: '페미닌',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/페미닌/158313368830164700_137136785.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/로맨틱/Millimeter_234_imgs.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/섹시/1-(9)-005-272-2,351-7,514-FisrtGI_317_09.jpg'
          ]
        },
        {
          title: '에스닉 : 민족의 고유 복장부터 멋스럽고 감각적인 현대 스타일까지',
          hashtag: ['# 기하학', '# 패턴', '# 고풍스러운'],
          content: '에스닉은 다양한 문화권이 패션에 담긴 스타일이라고 할 수 있습니다. 과거로부터 이어온 역사깊은 감성과 패턴은 지금 보아도 다른 사람들의 시선을 빼앗기에 부족함이 없습니다. 독특하고 유니크한 스타일을 눈에 띄는 스타일입니다.',
          subStyle: ['히피','웨스턴','오리엔탈'],
          end: '<span style="color:red;">아메카지</span>같은 스타일을 좋아한다면?',
          style: '에스닉',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/히피/sk2788k06-sk2788k06-s_12.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/웨스턴/1-(9)-005-272-2,351-7,514-FisrtGI_338_05.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/오리엔탈/Mico&co_090_04.jpg'
          ]
        },
        {
          title: '컨템포러리 : 도시적인 세련됨. 이것이 패션이다.',
          hashtag: ['# 도시적인', '# 세련됨', '# 눈이 가는'],
          content: '컨템포러리는 패션을 사랑하는 사람들이 좋아하는 좋아하는 스타일입니다. 다른 사람들에게 단정한 느낌을 줄 수 있기 때문에, 뽐내고 싶은 자리나 단정한 인상을 주어야하는 자리에 추천하는 스타일입니다.',
          subStyle: ['모던','소피스티케이티드', '아방가르드'],
          end: '<span style="color:red;">단정한</span> 스타일을 좋아하시나요? ',
          style: '컨템포러리',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/모던/nt1138k8a-nt1138k8a-s_1.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/소피스트케이티드/Dduddu_319_08.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/아방가르드/sk2517c9c-600_1.jpg'
          ]
        },
        {
          title: '내추럴 : 편한 옷이 최고다.',
          hashtag: ['# 편안한', '# 대충 입음', '# 자연스러운'],
          content: '내추럴, 스타일 이름부터 더 설명할 것이 없는 편한 스타일입니다. 하위 스타일에 리조트가 있는데, 말 그대로 리조트에서 입을 만한 편하면서 하늘하늘한 스타일입니다. 스타일링에 있어서 편한게 최고라면 바로 내추럴을 선택하세요!',
          subStyle: ['컨트리','리조트'],
          end: '아우 귀찮아! 무엇보다 <span style="color:red;">편한게</span> 최고라면?',
          style: '내추럴',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/컨트리/Boddari_106_07.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/리조트/20201117_001549_아이스통바지-15881536223180600_13154680205.jpg',
          ]
        },
        {
          title: '젠더프루이드 : 남성복과 여성복의 경계를 허물다.',
          hashtag: ['# 반바지', '# 남녀공용', '# 꾸안꾸'],
          content: '젠더프루이드는 남녀 누구나 즐길 수 있는 편한 스타일입니다. 주로 반바지 스타일링이나 편하지만 멋을 낸 연출을 하고싶을 때 이용하면 좋은 스타일입니다. ',
          subStyle: ['젠더리스'],
          end: '무난하게 <span style="color:red;">포인트</span>를 주고싶다구요? 그렇다면!!!',
          style: '젠더프루이드',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/젠더리스/1 (28622).jpg'
          ]
        },
        {
          title: '스포티 : 곧 바로 운동하러 갑니다~',
          hashtag: ['# 역동적인', '# 운동', '# 레깅스'],
          content: '스포티는 남녀노소 운동을 좋아하는 사람이라면 한 번쯤 시도해본 스타일입니다. 맨투맨, 스포츠 브라탑, 민소매, 레깅스, 자전거 룩 등 힙하면서 편안한 스타일링이 가능합니다.',
          subStyle: ['스포티',],
          end: '<span style="color:red;">운동</span>을 좋아한다면 꾹 눌러주세요.',
          style: '스포티',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/스포티/20200922sfd-1 (2699).JPG'
          ]
        },
        {
          title: '서브컬쳐 : 개성있는 펑키 펑키 스타일',
          hashtag: ['# 힙합', '# 레트로', '# 개성있는'],
          content: '서브 컬쳐는 시대를 아우를 패션, 예전 느낌의 옷, 오버핏, 하의 실종 등 처음 접하면 다소 이상하게 보일 수 있는, 그렇지만 보면 볼수록 매력있고 관심이 가는 스타일입니다. 대표적으로 넓은 통 바지의 힙합 스타일이 있습니다.',
          subStyle: ['레트로','힙합','펑크'],
          end: '잠깐! 혹시 <span style="color:red;">체크무늬</span>를 좋아하시나요? 그렇다면!!!!!',
          style: '서브컬쳐',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/레트로/sk2836c07-270_3.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/힙합/bl3499c07-270_1.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/펑크/jk2229k03-jk2229k03-s_5.jpg'
          ]
          
        },
        {
          title: '캐주얼 : 어떤 장소, 분위기에도 어울리는 귀여운 스타일',
          hashtag: ['# 편안한', '# 일상적인', '# 대학생룩'],
          content: '캐주얼 스타일은 남녀노소 사랑하는 대표적인 스타일입니다. 어떤 장소나 분위기에도 무난하게 스타일링 가능하며 귀여운 스타일이고, 옷장을 들여다보면 누구나 가지고 있는 맨투맨, 후드티, 츄리닝이 캐주얼에 속합니다. 꾸민듯 안꾸밋든 멋진 캐주얼 스타일 어떠신가요?',
          subStyle: ['밀리터리','스트리트'],
          end: '잠깐! 혹시 <span style="color:red;">꾸안꾸</span>를 좋아하시나요? 그렇다면!!!!!',
          style: '캐주얼',
          subStyleImage: [
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/밀리터리/FallingJ_118_img.jpg',
            'https://j5b206.s3.ap-northeast-2.amazonaws.com/%EC%8A%A4%ED%8A%B8%EB%A6%AC%ED%8A%B8/lwerkjdjc_2%20(3064).jpg'
          ]
        },
      ]
    }),
    computed: {
      ...mapGetters(['getStyleImage', 'getStyleDepthImage', 'getStyleIndex']),
    },
    mounted() {
      const width = 450, height = 450
      let app = new PIXI.Application({width: width, height: height});
      
      const frame = document.getElementsByClassName('pixi')[0]
      console.log(frame)
      frame.appendChild(app.view)
      const img = new PIXI.Sprite.from(this.getStyleImage);
      img.width = width
      img.height = height

      app.stage.addChild(img);
      const depthMap = new PIXI.Sprite.from(this.getStyleDepthImage);
      depthMap.width = width
      depthMap.height = height
      app.stage.addChild(depthMap);

      const displacementFilter = new PIXI.filters.DisplacementFilter(depthMap);
      app.stage.filters = [displacementFilter];

      frame.onmousemove = function(e) {
        displacementFilter.scale.x = (width / 2 - e.clientX) / 50;
        displacementFilter.scale.y = (height / 2 - e.clientY) / 50;
      };
    },
    methods: {
      close () {
        this.$emit('close')
      },
      like (i) {
        const area = document.getElementsByClassName('image-area')[0]
        const heart = document.getElementById('heart')
        area.classList.add('back')
        heart.classList.add('heart')
        setTimeout(() => {
          this.close()
          this.$emit('like-style', i)
        }, 1500)
      }
    }
  }
</script>

<style scoped>
/* 스크롤 CSS */
.modal-container {
  overflow: scroll;
}
.modal-container::-webkit-scrollbar {
  width: 12px;
}
.modal-container::-webkit-scrollbar-thumb {
  background-color: #F875AA;
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}
.modal-container::-webkit-scrollbar-track {
  background-color: F4F9F9;
  border-radius: 10px;
  box-shadow: inset 0px 0px 5px white;
}
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
  width: 250px;
  height: 60px;
  line-height: 60px;
  font-size: 2vh;
  background-color: #F875AA;
  border-radius: 10px;
  margin: 0px 10px;
  color: #F4F9F9;
  cursor: pointer;
  text-align: center;
}
.text-content {
  font-family: ELAND_Choice_M;
}
.btn:hover {
  background-color: #F1D1D0;;
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
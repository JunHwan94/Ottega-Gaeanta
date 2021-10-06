<template>
  <div class="fpti-container">
    <swal-alert></swal-alert>
    <div align="center" style="margin-top:-50px;">
      <img :src="backgroundImage" class="fpti-back"/>
      <vueper-slides 3d class="no-shadow slider" fixed-height="600px" :arrows="false" :touchable="false" ref="fpti"
        bullets-outside transition-speed="250">
        <vueper-slide class="frame" :key="111">
          <template v-slot:content>
            <div class="mt-12">
              <h2>내 성격에 딱!<br>어울리는 룩은?</h2><br>
              <h4>룩으로 알아보는 내 패션성향, FPTI</h4>
              <div class="mt-5">
                <img :src="mainImage" />
              </div>
              <div class="btn mt-5" @click="$refs.fpti.next()">
                패피티아이 시작~!
              </div>
            </div>
          </template>
        </vueper-slide>
        <vueper-slide class="frame" v-for="survey in getSurveys" :key="survey.qno">
          <template v-slot:content>
            <div class="mt-12">
              <div class="pl-8 pr-8">
                <h3>Q{{survey.qno}}. {{survey.question}}</h3>
              </div>
              <div class="mt-5">
                <img :src="survey.iconUrl" />
              </div>
              <div v-for="(answer, index) in survey.answerList" :key="index">
                <div class="btn mt-2" @click="[select(survey.qno, index + 1)]">
                  <span>{{answer}}</span>
                </div>
              </div>
            </div>
          </template>
        </vueper-slide>
      </vueper-slides>
    </div>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import Swal from 'sweetalert2'
  import SwalAlert from '@/components/SwalAlert'
  import {
    VueperSlides,
    VueperSlide
  } from 'vueperslides'
  import 'vueperslides/dist/vueperslides.css'
  export default {
    components: {
      VueperSlides,
      VueperSlide,
      SwalAlert
    },
    computed: {
      ...mapGetters(["getSurveys"]),
    },
    data: () => ({
      backgroundImage: require('@/assets/fpti/fpti-background.png'),
      mainImage: require('@/assets/fpti/main.png'),
      // db 조회 안될 때 테스트 용
      // getSurveys: [{"qno": 1,"question": "당신의 옷장에는 어떤 옷이 많은가요?","answerList": ["셔츠, 블라우스", "후드, 맨투맨"]},{"qno": 2,"question": "당신의 옷들은 어떤 색인가요?","answerList": ["알록달록", "무채색"]},{"qno": 3,"question": "쇼핑하러 가면 어떤 옷을 사나요?","answerList": ["가성비 무난한 옷", "비싼 명품"]},{"qno": 4,"question": "유행하는 옷은 어떻게 한다?","answerList": ["바로 산다", "유행 안타는거 입음"]},{"qno": 5,"question": "평소 집에서 혼자 쉴때 당신의 옷차림은?","answerList": ["속옷바람", "편한 옷차림", "나홀로 패션쇼"]},{"qno": 6,"question": "당신은 친구들과 여행을 계획하고 있다. 다음 중 더 끌리는 곳은?","answerList": ["\"인간은 땅으로부터 왔소이다\" \n인적이 드문 산과 바다 또는 자연", "\"나는 인싸다\" 무적권 붐비는 핫 플레이스 "]},{"qno": 7,"question": "유튜브를 켜면 보통 가장 위에 있는 컨텐츠","answerList": ["뷰티", "개그", "사회과학", "야한거"]},{"qno": 8,"question": "로또 1등이 당첨되면 가장 먼저 할 일은?","answerList": ["갖고싶었던 차를 일시불로 지른다", "이자율이 높은 은행을 알아본다", "친구들한테 한 턱 쏜다!"]},{"qno": 9,"question": "친구가 패션에 대한 고민을 털어놓는다. 어떻게 할 것인가?","answerList": ["\"패션이란 말이야..\"로 운을 떼면서 조언을 해준다", "스타일은 타고나는 것, 앞에서 맞장구만 쳐준다", "패션에 대해 큰 관심이 없다. 주제를 다른 방향으로 바꿀 기회만 노린다. "]},{"qno": 10,"question": "내 핸드폰 케이스는","answerList": ["없다", "투명 케이스", "누런 투명 케이스", "색상 또는 이미지 프린트가 있는 케이스"]},{"qno": 11,"question": "지금 내 방 상태는","answerList": ["발 디딜 틈이 없다", "아직 사람이 지낼만한 수준이다", "우렁각시가 다녀갔나..? 싶을 정도로 깔끔하다"]},{"qno": 12,"question": "현재 내 지갑에 포함된 색 개수는?","answerList": ["1개", "2개", "3개 이상", "지갑같은거 안씀"]},{"problemNo": 13,"question": "지금 그림을 그린다면?","answerList": ["아름다웠던 곳을 기억해서 그린다", "지금 내가 느낀대로, 그리고 싶은대로 그린다"]}],
      stylePoints: {},
      answerCheck: [false, false, false, false, false, false, false, false, false, false, false, false, false, false],
      styleList: ['트레디셔널', '매니시', '페미닌', '에스닉', '컨템포러리', '내추럴', '젠더프루이드', '스포티', '서브컬쳐', '캐주얼'],
      pointMap: [
        {},
        { // 1
          1: ['매니시', '페미닌', '에스닉', '트레디셔널', '컨템포러리', ],
          2: ['캐주얼', '서브컬쳐', '스포티', '내추럴', '젠더프루이드'],
        },
        { // 2
          1: ['캐주얼', '서브컬쳐', '스포티', '내추럴', '젠더프루이드', ],
          2: ['매니시', '페미닌', '에스닉', '트레디셔널', '컨템포러리'],
        },
        { // 3
          1: ['캐주얼', '내추럴'],
          2: ['페미닌', '트레디셔널', ],
        },
        { // 4
          1: ['컨템포러리', '서브컬쳐', ],
          2: ['캐주얼', '내추럴', '젠더프루이드', '서브컬쳐', '스포티'],
        },
        { // 5
          1: ['트레디셔널', '에스닉', '내추럴'],
          2: ['스포티', '서브컬쳐', '캐주얼', '젠더프루이드'],
          3: ['매니시', '페미닌', '컨템포러리'],
        },
        { // 6
          1: ['스포티', '내추럴', '서브컬쳐', '캐주얼'],
          2: ['서브컬쳐', '컨템포러리', '페미닌'],
        },
        { // 7
          1: ['트레디셔널', '컨템포러리', '페미닌'],
          2: ['컨템포러리', '캐주얼', '내추럴', '서브컬쳐'],
          3: ['매니시'],
          4: ['페미닌'] // '야한거'라는 선택지 추후 삭제
        },
        { // 8
          1: ['에스닉', '매니시', ],
          2: ['내추럴'], // 스타일을 정의하지 못한 항목
          3: ['캐주얼', '스포티'],
        },
        { // 9
          1: ['컨템포러리', '서브컬쳐', '트레디셔널'], // 스타일을 정의하지 못한 항목
          2: ['내추럴', '스포티'], // 스타일을 정의하지 못한 항목
          3: ['캐주얼']
        },
        { // 10
          1: ['컨템포러리', '내추럴', '젠더프루이드'],
          2: ['페미닌', '내추럴'],
          3: ['캐주얼', '서브컬쳐'],
          4: ['에스닉'],
        },
        { // 11
          1: ['서브컬쳐', '스포티', ],
          2: ['캐주얼', '내추럴'],
          3: ['매니시', '페미닌', '에스닉', '트레디셔널', ],
        },
        { // 12
          1: ['컨템포러리', '매니시', ],
          2: ['캐주얼', '내추럴'],
          3: ['서브컬쳐', '에스닉'],
          4: ['스포티'],
        },
        { // 13
          1: ['트레디셔널', '페미닌', '에스닉', '컨템포러리', '내추럴'],
          2: ['매니시', '젠더프루이드', '스포티', '서브컬쳐', '캐주얼'],
        }
      ],
    }),
    created() {
      this.$store.dispatch('getSurveys')
        .then((response) => {
          console.log(response.data.surveys);
          this.$store.commit('SAVE_FPTI_SURVEYS', response.data.surveys)
        })
    },
    mounted() {
      // fpti point init
      for (let i = 0; i < this.styleList.length; i++) {
        this.stylePoints[this.styleList[i]] = 0
      }
    },
    methods: {
      select(qno, ansIndex) {
        
        this.answerCheck[qno] = true
        const styleArr = this.pointMap[qno][ansIndex]
        // console.log(styleArr)
        for (let i = 0; i < styleArr.length; i++) {
          this.stylePoints[styleArr[i]] += 10 // 문항 별 스타일 점수 부여
        }
        if (qno == this.getSurveys.length) { // 마지막 문항인 경우
          let isDone = true
          for (let i = 1; i < this.answerCheck.length; i++) {
            if (this.answerCheck[i] === false) {
              isDone = false
              this.$children[0].$vnode.componentInstance.swalAlert('error', '모든 문제에 대한 <br>답을 해야합니다!')
                .then(() => {
                  this.$refs.fpti.goToSlide(i)
                })
              if (!isDone) {
                return
              }
            }
          }
          const answerArr = []
          for (let i = 0; i < this.styleList.length; i++) {
            answerArr[i] = this.stylePoints[this.styleList[i]]
          }
          console.log(answerArr)
          let query = '?'
          for (let i = 0; i < answerArr.length - 1; i++) {
            query += 'arr=' + answerArr[i] + '&'
          }
          query += 'arr=' + answerArr[answerArr.length - 1]
          
          this.$store.dispatch('getSurveyResult', query)
            .then((response) => {
              this.$store.commit('SAVE_FPTI_RESULT', response.data.type)
              this.$children[0].$vnode.componentInstance.swalAlert('success', '성향 분석이 완료되었습니다.')
                .then(() => {
                  this.$router.push('/fptiResult')
                })
            })
          return
        }
        this.$refs.fpti.next() // next page
      }
    }
  }
</script>

<style scoped>
.fpti-container {
  margin-top: 15rem;
  /* height: 100vh; */
}

.slider {
  width: 450px;
}

.frame {
  border: 3px solid hotpink;
  background-color: white;
}

img {
  width: 200px;
  height: 200px;
}

.btn {
  width: 350px;
  height: 60px;
  line-height: 60px;
  border-radius: 5px;
  background-color: #F875AA;
  color: white;
  cursor: pointer;
  font-weight: bold;
}

.btn:hover {
  background-color: black;
}
.fpti-back {
  width: 80vw; 
  height: 90vh; 
  position: fixed; 
  top: 5vh; 
  left: 10vw; 
  z-index: 1;
}
</style>
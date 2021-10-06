<template>
  <div class="nav-container">
    <div class="header">
      <div class="left" @click="changePage(0)">
        <h2>Ottega-Gaeanta</h2>
      </div>
      <div class="right" justify-end>
        <div class="top-menu" align="center" v-if="chooseStyleMenuVisibleState">
          <div>
            <img :src="changeStyleImg" @click="clickChangeStyleMenu()" />
            <div class="nav-menu">
              <span @click="clickChangeStyleMenu()">스타일 변경</span>
            </div>
          </div>
        </div>
        <div class="top-menu">
          <div>
            <img :src="hangerImg" @click="clickMenu()" />
            <div class="nav-menu">
              <span @click="clickMenu()">메뉴</span>
            </div>
          </div>
          <div class="menu-detail" align="right" v-if="menuVisible">
            <ul align="left">
              <li v-for="(item, index) in items" :key="index" @click="changePage(index)">{{item}}</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <br>
    <!-- <v-divider></v-divider> -->
    <!-- <div class="menu-detail" align="right">

    </div> -->
  </div>
</template>

<script>
  import {
    mapGetters,
    mapState
  } from "vuex";
  export default {
    name: 'NavBar',
    data: () => ({
      hangerImg: require('@/assets/hanger.png'),
      changeStyleImg: require('@/assets/changestylelogo.png'),
      menuVisible: false,
      styleMenuVisible: false,
      btns: [
        ['Large', 'lg'],
      ],
      colors: ['#F875AA'],
      items: ['메인으로', '스타일 검색', '의상 색 조합 분석', 'FPTI(패피티아이)', ],
      pages: ['/', '/searchResult', '/evaluationMain', '/fpti'], // fpti
    }),
    computed: {
      ...mapGetters(['getVideoStream', 'getSelectedUserStyle', 'getChooseStyleMenuVisibleState']),
      ...mapState(['chooseStyleMenuVisibleState']),
    },
    watch: {
      // getChooseStyleMenuVisibleState() {
      //   alert('스타일 변경 시 ')
      //   this.styleMenuVisible ,= this.getChooseStyleMenuVisibleState
      // },
      chooseStyleMenuVisibleState: function() {
        // alert('tst')
      }
    },
    methods: {
      changePage(index) {
        this.menuVisible = false
        // if (this.getVideoStream != null) { // 웹 캠 객체가 활성화 상태이면 비활성 처리함
        //   const tracks = this.getVideoStream.getTracks()
        //   tracks.forEach(track => {
        //     track.stop();
        //   });
        // }
        if (index == 1 && this.getSelectedUserStyle == null) { // 선호 스타일 미지정 상태로 검색페이지 이동 시, 선호 스타일을 페이지로 이동
          this.$router.push('/chooseStyle')
          return
        }
        this.$router.push(this.pages[index])
        // const path = this.$route.fullPath
        // console.log(this.$route)
        // if (path == '/searchResult') { // 스타일 검색 페이지 이면 ㅅ타일 변경 메뉴 활성화
        //   setTimeout(() => {
        //     this.styleMenuVisible = true
        //     alert('tesa')
        //   }, 1500);
        // } else {
        //   setTimeout(() => {
        //     this.styleMenuVisible = false
        //   }, 1500);
        // }
      },
      clickMenu() {
        this.menuVisible = !this.menuVisible
      },
      clickChangeStyleMenu() {
        this.$router.push('/chooseStyle')
      }
    }
  }
</script>

<style scoped>
  .header {
    padding: 20px;
    padding-left: 3%;
    padding-right: 3%;
    width: 100%;
  }

  .nav-container {
    z-index: 2;
    position: absolute;
    width: 100vw;
  }

  .left {
    width: 50%;
    float: left;
  }

  .left>h2 {
    cursor: pointer;
  }

  .right {
    width: 50%;
    float: right;
    text-align: right;
    font-family: Binggrae-Bold;
  }

  .top-menu {
    /* cursor: pointer; */
    margin-right: 10px;
    display: inline-block;
  }

  .top-menu img {
    width: 40px;
    height: 40px;
    cursor: pointer;
  }

  .nav-menu {
    margin-right: 5px;
    color: #F875AA;
  }

  .nav-menu>span {
    cursor: pointer;
  }

  .menu-detail {
    width: 200px;
    height: 200px;
    border-radius: 10px;
    border: 2px solid #F875AA;
    background: #F4F9F9;
    display: inline-block;
    position: absolute;
    z-index: 9999;
    left: 85vw;
  }

  ul {
    list-style: none;
    color: #F875AA;
  }

  ul>li {
    margin-top: 14px;
    margin-right: 35px;
    padding-left: 5px;
    height: 30px;
    line-height: 35px;
    border-radius: 15px;
    cursor: pointer;
  }

  li:hover {
    background: #F1D1D0;

  }
  /* .menu-frame { */
    /* display: inline-block; */
    /* margin: 0px 10px; */
  /* } */
</style>
<template>
  <div class="nav-container">
    <div class="header">
      <div class="left" @click="changePage(0)">
        <h2>Ottega-Gaeanta</h2>
      </div>
      <div class="right" justify-end>
        <!-- <v-menu v-for="([text, rounded], index) in btns" :key="text" :rounded="rounded" offset-y>
          <template v-slot:activator="{ attrs, on }">
            <v-btn :color="colors[index]" class="white--text" v-bind="attrs" v-on="on">
              메뉴
            </v-btn>
          </template>

          <v-list>
            <v-list-item v-for="(item, index) in items" :key="item" link>
              <v-list-item-title v-text="item" @click="changePage(index)"></v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu> -->
        <div class="top-menu">
          <div>
          <img :src="hangerImg" @click="clickMenu()"/>
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
  import { mapGetters } from "vuex";
  export default {
    name: 'NavBar',
    data: () => ({
      hangerImg: require('@/assets/hanger.png'),
      menuVisible: false,
      btns: [
        ['Large', 'lg'],
      ],
      colors: ['#F875AA'],
      items: ['메인으로', '의상 검색','색 조합 평가','FPTI(패피티아이)',],
      pages: ['/','/searchResult','/evaluationMain','/fpti'],
    }),
    computed: {
      ...mapGetters(["getVideoStream"]),
    },
    methods: {
      changePage(index) {
        this.menuVisible = false
        if (this.getVideoStream != null) { // 웹 캠 객체가 활성화 상태이면 비활성 처리함
          const tracks = this.getVideoStream.getTracks()
          tracks.forEach(track => {
            track.stop();
          });
        }
        this.$router.push(this.pages[index])
      },
      clickMenu() {
        this.menuVisible = !this.menuVisible
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
.left > h2 {
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
}
.top-menu:hover {

}
.top-menu img{
  width: 40px;
  height: 40px;
  cursor: pointer;
}
.nav-menu {
  margin-right: 5px;
  color: #F875AA;
}
.nav-menu > span {
  cursor: pointer;
}
.menu-detail {
  width: 200px;
  height: 200px;
  border-radius: 10px;
  border: 2px solid #F875AA;
  background: #F4F9F9;
  display: inline-block;
}
ul {
  list-style:none;
  color: #F875AA;
}
ul > li {
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
</style>
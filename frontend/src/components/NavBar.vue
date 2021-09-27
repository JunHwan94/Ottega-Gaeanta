<template>
  <div class="nav-container">
    <div class="header">
      <div class="left" @click="changePage(0)">
        <h2>Ottega-Gaeanta</h2>
      </div>
      <div class="right" justify-end>
        <v-menu v-for="([text, rounded], index) in btns" :key="text" :rounded="rounded" offset-y>
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
        </v-menu>
      </div>
    </div>
    <br>
    <!-- <v-divider></v-divider> -->
  </div>
</template>

<script>
  export default {
    name: 'NavBar',
    data: () => ({
      btns: [
        ['Large', 'lg'],
      ],
      colors: ['#F875AA'],
      items: ['메인으로', '의상 검색','입은 옷 색 조합 평가','미지정 메뉴',],
      pages: ['/','/searchResult','/evaluationMain','/'],
    }),
    methods: {
      changePage(index) {
        this.$router.push(this.pages[index])
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
}
</style>
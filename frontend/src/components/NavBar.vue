<template>
  <div>
    <div class="header">
      <div class="left">
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
            <v-list-item v-for="item in items" :key="item" link>
              <v-list-item-title v-text="item"></v-list-item-title>
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
      colors: ['teal darken-1'],
      items: [...Array(4)].map((_, i) => `Item ${i}`),
    }),
  }
</script>

<style scoped>
.header {
  padding: 20px;
  padding-left: 3%;
  padding-right: 3%;
  width: 100%;
}
.left {
  width: 50%;
  float: left;
}
.right {
  width: 50%;
  float: right;
  text-align: right;
}
</style>
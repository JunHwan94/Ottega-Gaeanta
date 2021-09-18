<template>
  <v-app>
    <nav-bar></nav-bar>
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
  import NavBar from '@/components/NavBar.vue'
  export default {
    name: 'App',
    components: {
      NavBar,
    },
    data: () => ({
    }),
    methods: {
    },
    mounted() {
      let script = document.createElement('script')
      script.setAttribute('src', 'https://docs.opencv.org/3.4/opencv.js')
      script.async = true;
      document.head.appendChild(script)
    }
  };
</script>
<style scoped>
@font-face {
    font-family: 'Binggrae-Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/Binggrae-Bold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
  font-family: 'HSYuji-Regular';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/HSYuji-Regular.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
@font-face {
  font-family: 'Cafe24Ssurround';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/Cafe24Ssurround.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
</style>
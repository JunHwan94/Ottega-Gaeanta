<template>
  <v-app>
    <nav-bar></nav-bar>
    <v-main>
      <loading-spinner :loading="getLoadingSpinnerStatus"/>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
  import { mapGetters } from 'vuex'
  import NavBar from '@/components/NavBar.vue'
  import LoadingSpinner from '@/components/loadingSpinner/LoadingSpinner.vue'
  export default {
    name: 'App',
    components: {
      NavBar,
      LoadingSpinner,
    },
    data: () => ({
    }),
    computed: {
      ...mapGetters(["getLoadingSpinnerStatus"]),
    },
    methods: {
    },
    mounted() {
      // open cv script
      let script = document.createElement('script')
      script.setAttribute('src', 'https://docs.opencv.org/3.4/opencv.js')
      script.async = true;
      document.head.appendChild(script)

      // pixi script
      script = document.createElement('script')
      script.setAttribute('src', 'https://cdnjs.cloudflare.com/ajax/libs/pixi.js/5.1.3/pixi.min.js')
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
  font-family: 'Cafe24Ssurround';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/Cafe24Ssurround.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
@font-face {
  font-family: 'ELAND_Choice_M';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts-20-12@1.0/ELAND_Choice_M.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
</style>
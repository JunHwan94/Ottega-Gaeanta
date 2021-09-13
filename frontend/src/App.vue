<template>
  <v-app>
    <nav-bar></nav-bar>
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
  import NavBar from '../src/components/NavBar.vue'
  export default {
    name: 'App',
    components: {
      NavBar,
    },
    data: () => ({
    }),
    methods: {
      aaa() {
        alert('test')
        this.$router.push('landing')
      }
    }
  };
</script>
<style>
</style>
<template>
  <div class="lds-facebook" v-if="loading">
    <div>
    </div>
    <div>
    </div>
    <div>
    </div>
  </div>
  <!-- <div align="center" v-if="loading" class="test">
    <img :src='image' style='margin: 0px auto;'/>
  </div> -->
  </template>

<script>
  export default {
    props: {
        loading: {
            type: Boolean,
            required: true
        }
    },
    name: 'LoadingSpinner',
    data: () => ({
      image: require('@/assets/zzz.gif'),
    }),
    computed: {
    },
    methods: {
    }
  }
</script>

<style scoped>
/*
.test {
  position: fixed;
  top: 50%;
  left: 50%;
  z-index: 999;
}
.test > img {
  width: 100px;
  height: 100px;
}
*/
.lds-facebook {
  display: inline-block;
  position: absolute;
  width: 64px;
  height: 64px;
  top: 47%;
  left: 47%;
  z-index: 10;
}
.lds-facebook div {
    display: inline-block;
    position: absolute;
    left: 6px;
    width: 13px;
    background: #FBACCC;
    animation: lds-facebook 1.2s cubic-bezier(0, 0.5, 0.5, 1) infinite;
}
.lds-facebook div:nth-child(1) {
    left: 6px;
    animation-delay: -0.24s;
}
.lds-facebook div:nth-child(2) {
    left: 26px;
    animation-delay: -0.12s;
}
.lds-facebook div:nth-child(3) {
    left: 45px;
    animation-delay: 0;
}
@keyframes lds-facebook {
    0% {
        top: 6px;
        height: 51px;
    }
    50%, 100% {
        top: 19px;
        height: 25px;
    }
}
</style>
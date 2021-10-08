<template>
  <!-- <div class="lds-facebook" v-if="loading">
    <div>
    </div>
    <div>
    </div>
    <div>
    </div>
  </div> -->
  <div v-if="loading" class="loadingSpinnerBackground">
    <div align="center" class="test">
      <img class="animation" :src="image" style='margin: 0px auto;'/><br>
      <img class="message" :src="message"/>
    </div>
  </div>
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
      image: require('@/assets/loading.gif'),
      message: require('@/assets/loading-message.gif')
    }),
    computed: {
    },
    methods: {
    }
  }
</script>

<style scoped>
.loadingSpinnerBackground {
  position: fixed;
  width: 100vw;
  height: 100vh;
  background-color: rgba( 0, 0, 0, 0.4 );
  z-index: 998;
}
.test {
  position: fixed;
  top: 40%;
  left: 40%;
  z-index: 999;
}
.animation {
  width: 400px;
  height: 200px;
}
.message {
  width: 200px;
  height: 300px;
  position: fixed;
  top: 43%;
  left: 45%;
  z-index: 999;
}

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
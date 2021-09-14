<template>
  <div>
    <landing-main></landing-main>
    <landing-slider></landing-slider>
  </div>
</template>

<script>
import LandingMain from '@/components/landing/LandingMain.vue'
import LandingSlider from '@/components/landing/LandingSlider.vue'
export default {
  components: {
    LandingMain,
    LandingSlider,
  },
  data: () => ({
  }),
}
</script>

<style scoped>
</style>
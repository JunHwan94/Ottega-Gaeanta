import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import "vuetify/dist/vuetify.min.css";
import { VueMasonryPlugin } from "vue-masonry";
import infiniteLoading from 'vue-infinite-loading'

Vue.config.productionTip = false
Vue.use(VueMasonryPlugin);

new Vue({
  router,
  store,
  vuetify,
  infiniteLoading,
  render: h => h(App)
}).$mount('#app')

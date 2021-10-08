import Vue from 'vue'
import VueRouter from 'vue-router'
import Landing from '../views/landing/Landing.vue'
import ChooseStyle from '../views/style/ChooseStyle.vue'
import SearchResult from '../views/search/SearchResult.vue'
import SearchItems from '../components/search/SearchItems.vue'
import SearchDetail from '../components/search/SearchDetail.vue'
import ChangeStyleModal from '../components/search/ChangeStyleModal.vue'
import EvaluationMain from '../views/evaluation/EvaluationMain.vue'
import EvaluationFilm from '../views/evaluation/EvaluationFilm.vue'
import EvaluationResult from '../views/evaluation/EvaluationResult.vue'
import Fpti from '../views/fpti/Fpti.vue'
import FptiResult from '../views/fpti/FptiResult.vue'
import FptiResultKakaoShared from '../views/fpti/FptiResultKakaoShared.vue'
import store from '../store/index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'LandingMain',
    component: Landing
  },
  {
    path: '/landing',
    name: 'Landing',
    component: Landing
  },
  {
    path: '/chooseStyle',
    name: 'ChooseStyle',
    component: ChooseStyle
  },
  {
    path: '/searchResult',
    name: 'SearchResult',
    component: SearchResult
  },
  {
    path: '/searchItems',
    name: 'SearchItems',
    component: SearchItems
  },
  {
    path: '/searchDetail',
    name: 'SearchDetail',
    component: SearchDetail
  },
  {
    path: '/changeStyleModal',
    name: 'ChangeStyleModal',
    component: ChangeStyleModal
  },
  {
    path: '/evaluationMain',
    name: 'EvaluationMain',
    component: EvaluationMain
  },
  {
    path: '/evaluationFilm',
    name: 'EvaluationFilm',
    component: EvaluationFilm
  },
  {
    path: '/evaluationResult',
    name: 'EvaluationResult',
    component: EvaluationResult
  },
  {
    path: '/fpti',
    name: 'Fpti',
    component: Fpti
  },
  {
    path: '/fptiResult',
    name: 'FptiResult',
    component: FptiResult
  },
  {
    path: '/fptiResult/:typeno',
    name: 'FptiResultKakaoShared',
    component: FptiResultKakaoShared
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if(to.fullPath !== '/searchResult') { store.state.chooseStyleMenuVisibleState = false }
  store.commit('startSpinner');
  setTimeout(() => {
      next();
  }, 1500);
})

router.afterEach((to, from) => {
  store.commit('endSpinner');
})

export default router

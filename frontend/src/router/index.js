import Vue from 'vue'
import VueRouter from 'vue-router'
import Landing from '../views/landing/Landing.vue'
import ChooseStyle from '../views/style/ChooseStyle.vue'
import SearchResult from '../views/search/SearchResult.vue'
import SearchItems from '../views/search/SearchItems.vue'
import SearchDetail from '../views/search/SearchDetail.vue'
import EvaluationCamera from '../views/evaluation/EvaluationCamera.vue'
import EvaluationFilm from '../views/evaluation/EvaluationFilm.vue'
import EvaluationResult from '../views/evaluation/EvaluationResult.vue'

Vue.use(VueRouter)

const routes = [
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
    path: '/evaluationCamera',
    name: 'EvaluationCamera',
    component: EvaluationCamera
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
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

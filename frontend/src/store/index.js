import Vue from 'vue'
import Vuex from 'vuex'
import state from './modules/state'
import * as actions from './modules/actions'
import * as mutations from './modules/mutations'
import * as getters from './modules/getters'

Vue.use(Vuex)

export default new Vuex.Store({
  namespaced: true,
  state,
  mutations,
  getters,
  actions,
  modules: {}
})

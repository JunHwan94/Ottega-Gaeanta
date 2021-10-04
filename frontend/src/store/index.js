import Vue from 'vue'
import Vuex from 'vuex'
import state from './modules/state'
import * as actions from './modules/actions'
import * as mutations from './modules/mutations'
import * as getters from './modules/getters'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
  plugins: [createPersistedState()],
  namespaced: true,
  state,
  mutations,
  getters,
  actions,
  modules: {}
})

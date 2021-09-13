// import $axios from 'axios'

// axios 샘플
export function showStyleInfo({ commit }, credentials) {
    const showSearchDetail = !credentials.showSearchDetail
    commit("SEARCH_STYLE_UNIT_INFO", showSearchDetail)
}
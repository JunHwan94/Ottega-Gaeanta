// import $axios from 'axios'

import axios from 'axios'
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

const baseUrl = 'https://localhost:443/'
// axios 샘플
export function showStyleInfo({ commit }, credentials) {
    const showSearchDetail = !credentials.showSearchDetail
    const imgURL = credentials.imgURL

    commit("SEARCH_STYLE_UNIT_INFO", showSearchDetail)
    commit("SEARCH_DETAIL_IMAGE_URL", imgURL)
}
export function showSearchItems({ commit }, credentials) {
    const searchItemsBool = !credentials.searchItemsBool
    commit("SEARCH_ITEMS_CATEGORY", searchItemsBool)
}

export function evaluateImage({ commit }, image) {
    console.log(image)
    const url = baseUrl + 'eval/input'
    return axios.post(url, image)
}

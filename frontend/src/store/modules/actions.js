// import $axios from 'axios'

import axios from 'axios'
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

// const baseUrl = 'https://localhost:443/'
const baseUrl = 'https://j5b206.p.ssafy.io:443/'
// axios 샘플
export function showStyleInfo({ commit }, credentials) {
    const showSearchDetail = !credentials.showSearchDetail
    const imgURL = credentials.imgURL

    commit("SEARCH_STYLE_UNIT_INFO", showSearchDetail)
    commit("SEARCH_DETAIL_IMAGE_URL", imgURL)
}
export function showSearchItems({ commit }, searchReq) {
    console.log(searchReq)
    const url = baseUrl + "search/s3image"
    return axios.post(url, searchReq)
}

export function evaluateImage({ commit }, image) {
    console.log(image)
    const url = baseUrl + 'eval/input'
    return axios.post(url, image)
}

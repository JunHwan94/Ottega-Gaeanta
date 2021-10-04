// import $axios from 'axios'


import axios from 'axios'
import store from '../index'

axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
axios.interceptors.request.use(
  config => {
      store.commit('startSpinner');
      return config;
  },
  error => {
      alert('데이터 요청 실패');
      return Promise.reject(error);
  }
);

axios.interceptors.response.use(
  response => {
      store.commit('endSpinner');
      return response;
  },
  error => {
      alert('데이터 응답 실패');
      return Promise.reject(error);
  }
)

const baseUrl = 'https://localhost:443/'
// const baseUrl = 'https://j5b206.p.ssafy.io:443/'
// const baseUrl = 'https://52.78.73.111:443/'
// axios 샘플
export function showStyleInfo({ commit, getters }, credentials) {
    const showSearchDetail = !credentials.showSearchDetail
    const imgURL = credentials.imgURL   // 이미지 URL
    const index = credentials.idx   // 해당 파일의 배열 인덱스 
    const imageDetail = getters['getImageInfos']    // 인덱스로 사진 정보 배열에서 가져온 디테일 정보

    commit("SEARCH_STYLE_UNIT_INFO", showSearchDetail)
    commit("SEARCH_DETAIL_IMAGE_URL", imgURL)
    commit("setImageDetail", imageDetail[index])

    // console.log(imageDetail[index].style[[0]].style)
    getSimillarStyles(imageDetail[index].style[[0]].style).then((result) => {
        commit("setSimillarStyles", result.data)
    })
    // console.log(simillarImages)
    // commit("setSimillarStyles", simillarImages)
}
export function showSearchItems({ commit }, searchReq) {
    const url = baseUrl + "search/s3image"
    return axios.post(url, searchReq)
}

export function evaluateImage({ commit }, image) {
    const url = baseUrl + 'eval/input'
    return axios.post(url, image)
}

export function getSurveys() {
    const url = baseUrl + '/fpti/getSurveys'
    return axios.get(url)
}

function getSimillarStyles(style) {
    const url = baseUrl + '/search/simillar/' + style
    return axios.get(url)
}

export function getSurveyResult({ commit }, query) {
  const url = baseUrl + '/fpti/result' + query
  return axios.post(url)
}
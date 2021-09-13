import $axios from 'axios'

// axios 샘플
export function test({ state }) {
    console.log(state)
    return $axios.get('www.naver.com')
}
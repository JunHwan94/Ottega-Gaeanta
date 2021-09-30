// mutations 테스트
export function SEARCH_STYLE_UNIT_INFO (state, showSearchDetail) {
    state.showSearchDetail = showSearchDetail
}
export function SEARCH_ITEMS_CATEGORY (state, searchItemsBool) {
    state.searchItemsBool = searchItemsBool
}
export function SEARCH_DETAIL_IMAGE_URL (state, searchDetailImageURL) {
    state.searchDetailImageURL = searchDetailImageURL
}
export function SAVE_VIDEO_STREAM (state, stream) {
    state.videoStream = stream
}
export function SAVE_SELECTED_USER_STYLE (state, selectedUserStyle) {
  state.selectedUserStyle = selectedUserStyle
}
export function SAVE_USER_FASHION_RATE (state, userFashionRate) {
  state.userFashionRate = userFashionRate
  console.log(state.userFashionRate)
}

// 검색 request 객체 setting
export function setSearchReq (state, searchReq) {
  state.searchReq = searchReq
}

// 이미지 배열에 검색 결과 배열 추가
export function setImages (state, data) {
  state.images = data.s3url
  state.imageInfos = data.clothes
}

// 이미지 배열에 이미지 추가
export function addImages(state, data) {
  const image = data.s3url
  const cloth = data.clothes

  for (let i = 0; i < image.length; i++){
    state.images.push(image[i])
  }
  for (let i = 0; i < cloth.length; i++){
    state.imageInfos.push(cloth[i])
  }
}

// 검색창 처음 들어오면 무한 스크롤 비활성화 시키는 초기화 진행
export function initInfin (state) {
  state.infin = false
}

// 검색 시작. 무한 스크롤 활성화
export function searchStart (state) {
  state.infin = true
}

// 이미지 디테일 json 픽스
export function setImageDetail (state, detail) {
  state.imageDetail = detail
}

export function SAVE_FPTI_SURVEYS (state, surveys) {
  state.surveys = surveys
}
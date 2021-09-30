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
export function setSearchReq (state, searchReq) {
  state.searchReq = searchReq
}

export function setImages (state, images) {
  state.images = images
}

export function addImages (state, images) {
  for (let i = 0; i < images.length; i++){
    state.images.push(images[i])
  }
}

export function initInfin (state) {
  state.infin = false
}

export function searchStart (state) {
  state.infin = true
}

export function SAVE_FPTI_SURVEYS (state, surveys) {
  state.surveys = surveys
}
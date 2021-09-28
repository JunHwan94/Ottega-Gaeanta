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
const showSearchDetail = false
const searchItemsBool = false
const images = [] // 이미지 URL 배열
const imageInfos = [] // 사진 정보 담고 있는 Json 배열
const imageDetail = ''  // 사진 정보 디테일 JSON
const searchReq = {   // 검색 action 들어갈 request 객체
  style : [],
  cloth : '',
  category : '',
  color : '',
  print : '',
  page : 0
};
const userEvaluationImage = null
const evalSameColorStyle = []
const simillarStyles = []
const searchDetailImageURL = '@/assets/3.jpg'
const videoStream = null
const selectedUserStyle = null
const userFashionRate = []
const infin = false   // 검색 기능 시에 무한 스크롤 실행 여부. 처음 검색창에 들어가면 비활성화, 처음 검색 결과 이후 활성화
const surveys = []
const LoadingStatus = false
const styleImage = null
const styleDepthImage = null
let styleIndex = 0
const fptiResult = null
const colorModalState = false
const chooseStyleMenuVisibleState = false

export default function () {
  return {
    showSearchDetail,
    searchItemsBool,
    images,
    imageInfos,
    imageDetail,
    searchDetailImageURL,
    simillarStyles,
    videoStream,
    evalSameColorStyle,
    infin,
    searchReq,
    selectedUserStyle,
    userFashionRate,
    surveys,
    LoadingStatus,
    styleImage,
    styleDepthImage,
    styleIndex,
    fptiResult,
    colorModalState,
    chooseStyleMenuVisibleState,
    userEvaluationImage
  }
}
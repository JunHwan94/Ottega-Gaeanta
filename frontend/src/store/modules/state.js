const showSearchDetail = false
const searchItemsBool = false
const images = []
const searchReq = {
  style : ['페미닌'],
  cloth : '',
  category : '',
  color : '',
  print : '',
  page : 0
};
const searchDetailImageURL = '@/assets/3.jpg'
const videoStream = null
const selectedUserStyle = []
const userFashionRate = []
const infin = false

export default function () {
  return {
    showSearchDetail,
    searchItemsBool,
    images,
    searchDetailImageURL,
    videoStream,
    infin,
    searchReq,
    selectedUserStyle,
    userFashionRate
  }
}
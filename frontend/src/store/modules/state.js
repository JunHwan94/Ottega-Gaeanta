const showSearchDetail = false
const searchItemsBool = false
const images = []
const searchReq = {
  style : ['페미닌'],
  cloth : '',
  category : '',
  color : '',
  print : '',
  page : 1,
};
const searchDetailImageURL = '@/assets/3.jpg'
const videoStream = null
const selectedUserStyle = []
const userFashionRate = []

export default function () {
  return {
    showSearchDetail,
    searchItemsBool,
    images,
    searchDetailImageURL,
    videoStream,
    selectedUserStyle,
    userFashionRate
  }
}
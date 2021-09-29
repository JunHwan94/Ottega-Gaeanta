const showSearchDetail = false
const searchItemsBool = false
const images = [
  "https://j5b206.s3.ap-northeast-2.amazonaws.com/모던/20190814-bl2636k98(3)투메이(대행,베네통)8.16-얼굴컷 사진 셀렉 신경써주시고 제품컷 color 맞춰서 작업해주세여-DHP05169.JPG",
    "https://j5b206.s3.ap-northeast-2.amazonaws.com/모던/20190813-cd722k98(3)-커피샤워(대행,반반Y)8.14-얼굴컷 사진 셀렉 신경써주시고 제품컷 color 맞춰서 작업해주세여-DHP09378.JPG",
    "https://j5b206.s3.ap-northeast-2.amazonaws.com/모던/20190813-cd722k98(3)-커피샤워(대행,반반Y)8.14-얼굴컷 사진 셀렉 신경써주시고 제품컷 color 맞춰서 작업해주세여-DHP09362.JPG",
    "https://j5b206.s3.ap-northeast-2.amazonaws.com/모던/20190813-cd722k98(3)-커피샤워(대행,반반Y)8.14-얼굴컷 사진 셀렉 신경써주시고 제품컷 color 맞춰서 작업해주세여-DHP09330.JPG",
    "https://j5b206.s3.ap-northeast-2.amazonaws.com/모던/20190813-cd722k98(3)-커피샤워(대행,반반Y)8.14-얼굴컷 사진 셀렉 신경써주시고 제품컷 color 맞춰서 작업해주세여-DHP09350.JPG",
    "https://j5b206.s3.ap-northeast-2.amazonaws.com/모던/20190813-cd722k98(3)-커피샤워(대행,반반Y)8.14-얼굴컷 사진 셀렉 신경써주시고 제품컷 color 맞춰서 작업해주세여-DHP09374.JPG"
]
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
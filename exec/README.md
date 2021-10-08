# gitlab 소스 코드 클론 이후 빌드 및 배포할 수 있는 작업 문서
### 1. 프로젝트 개발 설정 값 및 버전
 - InteliJ IDE
    - IntelliJ IDEA Community Edition 2021.1.3 x64
 - vs code
    - 1.60.2 (user setup)

### 2. 빌드 시 사용되는 환경 변수 등의 주요 내용 상세 기재
 - 현재 디렉토리 관련 파일 업로드
### 3. 배포 시 특이사항
ssafy에서 제공한 aws에 application과 flask model server를 같이 운영했을 때, aws instance가 다운되는 문제가 있었습니다.   
application은 제공되는 aws에서 구동하고, flask model server는 개인 aws 배포 했습니다. (c5.9xlarge 요금제)

### 4. 데이터베이스 접속 정보
 mongoDB 데이터베이스 사용
 - id : root
 - pw : b4a1

# 프로젝트에서 사용하는 외부 서비스 정보 
 - kakao 공유하기

# 데이터베이스 덤프 파일 최신본
 - 현재 디렉토리 dump 폴더에 위치 참고

# 시연 시나리오(스크립트 포함)
 - 현재 디렉토리  scenario 폴더에 위치 참고

# Ottega Gaeanta


## 팀명 및 팀원

- 팀명 : B4A1 (대전 2반 6팀)
- 팀장 : 이재영
- 팀원 : 김백준, 김준환, 정범진, 정종우

## 기획(와이어프레임), 기획배경

- 기획 배경
    - 다양한 옷을 어떤 색 조합이나 스타일로 입을지 모르는 경우가 생김
    - 다량의 데이터를 기반으로 특정 옷의 색 조합에 부합하는 스타일을 찾아주면 좋을 것 같다 생각.

    → 120만건의 데이터 기반 패션 LOOKBOOK 서비스

- 와이어 프레임

    [B4A1 피그마 초안](https://www.figma.com/file/lhDtkfKlM8cGv4efBdTGrO/B4A1-%ED%94%BC%EA%B7%B8%EB%A7%88-%EC%B4%88%EC%95%88?node-id=0%3A1)

## 데이터 구조

- [DB 구조](https://www.notion.so/DB-31e92abfea9849eb915e8b67d74ee96e)

## 기능

1. 스타일 검색
2. 스타일 색 조합 평가
3. 퍼스널 컬러 진단

## 주요 기술스택(특이점)

- Frontend
    - Vue.js
- BackEnd
    - SpringBoot
    - MongoDB
    - Flask Model Server
        - MaskRCNN Model(Tensorflow), Pillow Library
        - Docker Flask Server
        - MaskRCNN Model 사용하여 상의, 하의, 아우터, 드레스 분리
        - Pillow Library 사용하여 색 추출
        - {“outer”:”beige”,"dress":"skyblue","pants":"","top":""}

            → Json 형식

        - Flask Server README.md Link ([https://lab.ssafy.com/s05-bigdata-dist/S05P21B206/-/tree/develop/backend/Flask Server](https://lab.ssafy.com/s05-bigdata-dist/S05P21B206/-/tree/develop/backend/Flask%20Server))
- Hadoop
    - 120만건의 패션 데이터 전처리
    - 추천 서비스 등의 기능 구현을 위한 데이터 분석 예정

## 배포주소(테스트)

- http://localhost:8095
- Flask Model Server(Test) : [http://j5b206.p.ssafy.io:8888/](http://j5b206.p.ssafy.io:8888/)

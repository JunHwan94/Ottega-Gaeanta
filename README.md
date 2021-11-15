## Ottega-Gaeanta 서버는 2021.10.15 이후로 비활성화 하였습니다.

# <img src="https://user-images.githubusercontent.com/58909226/139459983-d2ec3a58-bcf7-480d-b0b7-e44263daae8e.png" alt="image-20211029182657119" width="30" height="30"/> **Ottega Gaeanta**


옷을 어떻게 입을지 몰라 고민하는 사람들을 위해 120만건의 여성 패션 데이터를 기반한 Look-Book 서비스입니다.

- 총 개발 기간 : 6주
- 팀원 : 5명

## 기능

**1. 스타일 검색**

  - 사용자의 선호 스타일 3가지 입력
  - 입력한 선호 스타일을 기반하여 스타일 사진 목록 검색 기능 제공
  - 120만건의 데이터를 보여주기 전에, 많은 양의 데이터를 전처리하는데 Hadoop 사용 (이후 상세히 설명)
    ![image](https://sulfuric-wanderer-110.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F41a8ada8-ff9f-47aa-b53a-b8beea2d8f94%2FUntitled.png?table=block&id=6e393998-f289-4053-ab5f-5189c5c6413f&spaceId=5c928159-e10a-4899-bd21-9a5fc39423d3&width=1200&userId=&cache=v2)
  - <img src="https://sulfuric-wanderer-110.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fca25744f-3de8-47a4-8485-94b8efd5cd2d%2F%EA%B2%80%EC%83%89.png?table=block&id=b789b004-e30f-431e-b9ff-0d51ef784d49&spaceId=5c928159-e10a-4899-bd21-9a5fc39423d3&width=2000&userId=&cache=v2" alt="image-20211029182657119" width="600"/> 

**2. 스타일 색 조합 평가**

  - 사용자의 의상을 색 조합에 따라 등급화하여 보여주는 패션 평가 서비스
  - 웹캠을 활용한 방식과 이미지 업로드를 활용한 방식 두 가지를 지원
  - Mask R-CNN 모델을 사용하여 이미지의 상/하의 객체 인식 후, Pillow lib를 사용하여 평균 색 추출
  - 프로젝트 내의 개별적인 색 조합 등급표 기준으로 사용자의 색 조합 평가
    ![image](https://sulfuric-wanderer-110.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fa50239bc-c0b2-4e7d-8173-f59cf3888060%2FUntitled.png?table=block&id=a4a8f268-b7f7-42e9-ac47-89382dc52a7f&spaceId=5c928159-e10a-4899-bd21-9a5fc39423d3&width=1510&userId=&cache=v2) 


**3. 패피티아이**

  - MBTI + 패션 피플의 합성어

  - 사용자의 옷을 입는 스타일과 행동 성향을 파악할 수 있는 간단한 질문지를 통해 패션 성향을 알아보는 서비스

  - 13개의 질문으로 구성되어 있으며 모든 질문에 대한 답안을 선택하면 10개의 스타일 캐릭터 중 가장 점수가 높은 캐릭터로 결과 반환

  - 카카오톡 공유로, 결과 페이지 공유 가능

  - <img src="https://sulfuric-wanderer-110.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F61144a0b-ee77-4d66-9f88-d8e6cffaabab%2FFPTI.png?table=block&id=623dc022-9c54-4398-bb5e-e796f358306c&spaceId=5c928159-e10a-4899-bd21-9a5fc39423d3&width=2000&userId=&cache=v2" alt="image-20211029182657119" width="750" style="float:left"/>


## 와이어 프레임

**-** [B4A1 피그마 초안](https://www.figma.com/file/lhDtkfKlM8cGv4efBdTGrO/B4A1-%ED%94%BC%EA%B7%B8%EB%A7%88-%EC%B4%88%EC%95%88?node-id=0%3A1)

## 데이터 구조

**-** [DB 구조](https://www.notion.so/DB-31e92abfea9849eb915e8b67d74ee96e)

## 주요 기술스택(특이점)

**-** **Frontend**

 - Vue.js

   

**-** **BackEnd**

- SpringBoot
  - Gradle 6.7
  - SpringBoot v.2.4.5
- MongoDB
- Flask Model Server
  - MaskRCNN Model(Tensorflow), Pillow Library
  - Docker Flask Server
  - MaskRCNN Model 사용하여 상의, 하의, 아우터, 드레스 분리
  - Pillow Library 사용하여 색 추출
  - {“outer”:”beige”,"dress":"skyblue","pants":"","top":""} → Json 형식



**-** **Hadoop**

- 120만건의 패션 데이터 전처리

## 프로젝트 구조

![image](https://user-images.githubusercontent.com/58909226/139460031-105ea783-914d-4e40-a7c6-2e0c846479bf.png)

#### CI/CD

- commit을 하게 되면 GitLab에서 Jenkins 서버로 hook을 날립니다.
- Jenkins 서버에서 프로젝트의 jar파일을 제작합니다.
- Ottega-Gaeanta 메인 서버로 배포합니다.

#### Hadoop

- [AIhub](https://aihub.or.kr/aidata/7988) 에서 획득한 120만건의 여성 패션 데이터
- 필요하지 않은 Attribute는 제거
- 한글로 되어 있는 Attribute 네이밍을 영어로 변경
- Map-Reduce 병렬 분산처리 후 다시 파일을 하나로 합치는 작업 수행
- 머신 갯수 : 3

#### Mask R-CNN

- [Flask Server README.md Link](https://lab.ssafy.com/s05-bigdata-dist/S05P21B206/-/tree/develop/backend/Flask%20Server)
- [MaskRCNN-Modanet-Fashion-Segmentation-and-Classification](https://github.com/zekeriyyaa/MaskRCNN-Modanet-Fashion-Segmentation-and-Classification)
- R-CNN에서 세그먼트까지 추출하는 Mask R-CNN을 사용함으로써 패션 객체 추출
- Pillow lib (PIL) 사용하여 추출한 패션 이미지의 평균 색을 추출하여 상/하의의 색 조합을 평가

## 프로젝트 개발 이슈

### 1. PIXI Lib - FE

- 2차원 이미지를 입체적으로 표현해주는 라이브러리
  - 원본 이미지와 입체 효과를 줄 Map 이미지를 제작
  - 명도에 따라 움직이는 정도가 달라져 사용자에게 입체감을 주는 효과

- 움직임의 대상이 되는 모델의 테두리가 분할하는 문제
  - Map 이미지의 명도 구분을 최대한 부드럽게 하여 제작

### 2. Flask Server - BE

- Mask R-CNN 모델의 크기가 너무 커 배포 서버의 메모리가 부족해 다운되는 현상이 빈번히 발생
  - 팀원의 개인 서버로 모델을 옮겨 서버를 분할하여 해결
  - 비용 문제 발생

- 색 조합 평가를 하는 플라스크 서버 처리시간이 약 15~20초 정도 시간 소요
  - 비용 문제로 인해 AWS의 GPU 서버가 아닌 일반 서버로 구동
  - CPU를 통해 모델 처리가 되기 때문에 GPU 서버보다 훨씬 속도가 떨어짐
  - 자체 제작 Loading Spinner를 사용하여 사용자로 하여금 기다리는 시간이 지루하지 않는 효과를 주게 됨

### 3. MongoDB - BE

- 처음 사용하는 NoSQL 데이터베이스
  - Table에 맞게 Entity Class 제작으로 바로 매핑하여 자동으로 JSON 형태로 데이터 처리
  - RDB에서의 관계 매핑이 없어서 편리
  - 대용량의 데이터를 타겟으로 하는 프로젝트에 적합하다고 보임

### 4. Hadoop

- 전처리에만 사용하는 Hadoop
  - 처음 사용하는 빅데이터 처리 라이브러리인만큼 프로젝트 API에 적용하고 싶었으나 실패
  - Hadoop의 Map-Reduce 알고리즘에 대해 공부
  - Pandas, Spark 같은 플랫폼과 연동하여 사용하는 것인지, Spring-boot와 바로 Hadoop을 연동하는 다른 방법이 있는 것인지 공부할 필요가 있음

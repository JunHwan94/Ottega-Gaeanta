# Flask Readme

## MaskRCNN + Pillow Library

- MaskRCNN Model 사용하여 상의, 하의, 아우터, 드레스 분리
- Pillow Library 사용하여 색 추출
- {“outer”:”beige”,"dress":"skyblue","pants":"","top":""}

    → Json 형식

## Docker Flask

- AWS EC-2 Server  (/home/ubuntu) 경로
- Dockerfile과 app폴더 두개 유무 확인
- /home/ubuntu 경로에서 docker build -t {원하는 이름} .
ex) docker build -t server .
- docker run —name={원하는 컨테이너 이름} -p {원하는도커포트}:3000 server
ex) docker run —name=flask_server -p 8888:3000 server
- 6팀 aws 주소 기준으로 
[http://j5b206.p.ssafy.io:8888/](http://j5b206.p.ssafy.io:8888/)
로 접속하면 테스트할 수 있는 html 페이지가 나옴
- [POST] [http://j5b206.p.ssafy.io:8888/](http://j5b206.p.ssafy.io:8888/)model (with Image)
결과를 json 형식으로 반환
- Dockerfile

    ```jsx
    FROM python:3.6.8
      
    COPY ./app /app

    WORKDIR /app

    RUN pip install --upgrade pip
    RUN apt-get update && apt-get install -y --no-install-recommends apt-utils
    RUN pip install opencv-python
    RUN pip install -r requirements.txt

    WORKDIR /app/coco/PythonAPI
    RUN yes | pip uninstall h5py
    RUN yes | pip install 'h5py<3.0.0'
    RUN apt update
    RUN yes | apt-get install gcc
    RUN yes | apt-get install libgl1-mesa-glx
    RUN python setup.py install

    EXPOSE 3000

    WORKDIR /app
    CMD ["gunicorn", "app:app", "-b", "0.0.0.0:3000", "--timeout", "300", "-w", "3"]
    ```

- requirement.txt

    ```jsx
    tensorflow==1.15.2
    scikit-learn
    Pillow==8.1.0
    numpy
    scikit-image
    imutils
    Cython
    keras==2.3.1
    IPython
    imgaug
    flask-cors
    werkzeug
    gunicorn
    ```

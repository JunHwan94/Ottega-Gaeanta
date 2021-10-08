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
CMD ["gunicorn", "app:app", "-b", "0.0.0.0:3000", "--timeout", "0", "-w", "4", "--worker-class", "gevent"]

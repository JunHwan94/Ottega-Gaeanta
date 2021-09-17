import os

from flask import Flask, request, flash, jsonify
import flask
from flask_cors import CORS
from werkzeug.utils import secure_filename

# import config
import RGBExtractor.extract as extract
import MaskRCNN.model1.samples.custom.generateVggAnno as generate
import shutil

app = Flask(__name__)
CORS(app)
file = []
ROOT_DIR = os.path.abspath("./")
MaskModelImagePath = os.path.join(ROOT_DIR, "MaskRCNN/model1/images/")
ExtractImagePath = os.path.join(ROOT_DIR, "RGBExtractor/image")

def deleteAllfileInModel():
    if os.path.exists(MaskModelImagePath):
        for file in os.scandir(MaskModelImagePath):
            os.remove(file.path)
        return "Remove All File in GenerateVggAnno Model"
    else:
        return "Directory not found"

def deleteAllfileInExtract():
    if os.path.exists(ExtractImagePath):
        for file in os.scandir(ExtractImagePath):
            os.remove(file.path)
        return "Remove All File in GenerateVggAnno Model"
    else:
        return "Directory not found"

def moveTop():
    ii = [i for i in os.listdir(MaskModelImagePath) if 'top' in i]
    if len(ii) != 0:
        shutil.copy2(MaskModelImagePath+ii[0], ExtractImagePath)
        return True
    return False

def movePants():
    ii = [i for i in os.listdir(MaskModelImagePath) if 'pants' in i]
    if len(ii) != 0:
        shutil.copy2(MaskModelImagePath+ii[0], ExtractImagePath)
        return True

    return False

@app.route("/")
@app.route('/index')
def index():
    return flask.render_template('index.html')

@app.route("/model", methods=['POST'])
def uploadImageFile():
    top, pants, dress = '', '', ''
    if request.method == 'POST':
        if 'file' not in request.files:
            flash('No file part')
            print(MaskModelImagePath)
        file = request.files['file']
        if file.filename == '':
            flash('No selected file')
            print(MaskModelImagePath)
        else:
            filename = secure_filename(file.filename)
            deleteAllfileInModel()
            file.save(os.path.join(MaskModelImagePath, filename))
            generate.main()
            deleteAllfileInExtract()
            check = moveTop()
            if check:
                top = extract.main()
            deleteAllfileInExtract()
            check = movePants()
            if check:
                pants = extract.main()

    result = {'top' : top, 'pants' : pants, 'dress' : dress}
    print(result)
            
    return jsonify(result)


if __name__ == "__main__": 
    app.run(host='0.0.0.0', port='8000', debug=True)

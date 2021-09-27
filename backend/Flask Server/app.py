import os
from posix import O_ACCMODE

from flask import Flask, request, flash, jsonify
import flask
from flask_cors import CORS
from numpy.core.numerictypes import obj2sctype
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

def moveSkirt():
    ii = [i for i in os.listdir(MaskModelImagePath) if 'skirt' in i]
    if len(ii) != 0:
        shutil.copy2(MaskModelImagePath+ii[0], ExtractImagePath)
        return True

    return False

def moveDress():
    ii = [i for i in os.listdir(MaskModelImagePath) if 'dress' in i]
    if len(ii) != 0:
        shutil.copy2(MaskModelImagePath+ii[0], ExtractImagePath)
        return True

    return False

def moveOuter():
    ii = [i for i in os.listdir(MaskModelImagePath) if 'outer' in i]
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
    top, pants, skirt, dress, outer = '', '', '', '', ''
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
            deleteAllfileInExtract()
            check = moveSkirt()
            if check:
                skirt = extract.main()
            deleteAllfileInExtract()
            check = moveDress()
            if check:
                dress = extract.main()
            deleteAllfileInExtract()
            check = moveOuter()
            if check:
                outer = extract.main()

    if top is None and outer is not None:
        top = outer
    if top is None and pants is None and dress is not None:
        top = dress
        pants = dress
    if top is not None and outer is not None and dress is not None:
        top = outer
        pants = dress
    if pants is None and skirt is not None:
        pants = skirt
    if pants is None and dress is not None:
        pants = dress




    result = {'top' : top, 'pants' : pants}
    print(result)

    return jsonify(result)


if __name__ == "__main__":
    app.run(host='0.0.0.0', port='3000', debug=True)

# /opt/conda/envs/server/bin/gunicorn

import os
from flask import Flask, request, flash, jsonify
import flask
from flask_cors import CORS
from werkzeug.utils import secure_filename

# import config
import RGBExtractor.extract as extract
import MaskRCNN.model1.samples.custom.generateVggAnno as generate
import shutil
import uuid

app = Flask(__name__)
CORS(app)
file = []
ROOT_DIR = os.path.abspath("./")
MaskModelImagePath = os.path.join(ROOT_DIR, "MaskRCNN/model1/images/")
ExtractImagePath = os.path.join(ROOT_DIR, "RGBExtractor/image")
model =  None

def moveTop(filename):
    ii = [i for i in os.listdir(MaskModelImagePath) if filename+"_top" in i]
    if len(ii) != 0:
        shutil.copy2(MaskModelImagePath+ii[0], ExtractImagePath)
        return ii[0]
    return False

def movePants(filename):
    ii = [i for i in os.listdir(MaskModelImagePath) if filename+'_pants' in i]
    if len(ii) != 0:
        shutil.copy2(MaskModelImagePath+ii[0], ExtractImagePath)
        return ii[0]

    return False

def moveSkirt(filename):
    ii = [i for i in os.listdir(MaskModelImagePath) if filename+'_skirt' in i]
    if len(ii) != 0:
        shutil.copy2(MaskModelImagePath+ii[0], ExtractImagePath)
        return ii[0]

    return False

def moveDress(filename):
    ii = [i for i in os.listdir(MaskModelImagePath) if filename+'_dress' in i]
    if len(ii) != 0:
        shutil.copy2(MaskModelImagePath+ii[0], ExtractImagePath)
        return ii[0]

    return False

def moveOuter(filename):
    ii = [i for i in os.listdir(MaskModelImagePath) if filename+'_outer' in i]
    if len(ii) != 0:
        shutil.copy2(MaskModelImagePath+ii[0], ExtractImagePath)
        return ii[0]

    return False

# def load_model():
#     global model
#     model = generate.init()

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
            id = uuid.uuid4()
            filenameTemp = secure_filename(file.filename)
            filename = str(id) + "_" + filenameTemp
            filenameWithoutJPG = str(id) + "_" + os.path.splitext(filenameTemp)[0]

            file.save(os.path.join(MaskModelImagePath, filename))
            generate.main(filename)

            check = moveTop(filenameWithoutJPG)
            if check is not False:
                top = extract.main(check)

            check = movePants(filenameWithoutJPG)
            if check is not False:
                pants = extract.main(check)

            check = moveSkirt(filenameWithoutJPG)
            if check:
                skirt = extract.main(check)

            check = moveDress(filenameWithoutJPG)
            if check:
                dress = extract.main(check)

            check = moveOuter(filenameWithoutJPG)
            if check:
                outer = extract.main(check)

    if top is '' and outer is not '':
        top = outer
    if top is '' and pants is '' and dress is not '':
        top = dress
        pants = dress
    if top is not '' and outer is not '' and dress is not '':
        top = outer
        pants = dress
    if pants is '' and skirt is not '':
        pants = skirt
    if pants is '' and dress is not '':
        pants = dress
    
    result = {'top' : top, 'pants' : pants}
    print(result)
            
    return jsonify(result)



if __name__ == "__main__": 

    app.run(host='0.0.0.0', port='3000', debug=False)



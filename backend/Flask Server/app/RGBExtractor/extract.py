import math
import os

import numpy as np
import cv2
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt


def centroid_histogram(clt):
    # grab the number of different clusters and create a histogram
    # based on the number of pixels assigned to each cluster
    numLabels = np.arange(0, len(np.unique(clt.labels_)) + 1)
    (hist, _) = np.histogram(clt.labels_, bins=numLabels)

    # normalize the histogram, such that it sums to one
    hist = hist.astype("float")
    hist /= hist.sum()

    # return the histogram
    return hist




def plot_colors(hist, centroids, resultArray):
    # initialize the bar chart representing the relative frequency
    # of each of the colors
    bar = np.zeros((50, 300, 3), dtype="uint8")
    startX = 0

    # loop over the percentage of each cluster and the color of
    # each cluster
    index = 0
    for (percent, color) in zip(hist, centroids):
        # plot the relative percentage of each cluster

        #2중 배열에 퍼센티지와 RGB값을 넣어줌
        resultArray[index][0] = int(percent * 100)
        resultArray[index][1] = color.astype("uint8").tolist()
        resultArray.sort(key=lambda x: -x[0])

        endX = startX + (percent * 300)
        cv2.rectangle(bar, (int(startX), 0), (int(endX), 50),
                      color.astype("uint8").tolist(), -1)
        startX = endX
        index += 1

    # return the bar chart
    return bar

def main(filename):
    # file_names = next(os.walk('./image'))[2]
    #file_names = next(os.walk('./RGBExtractor/image'))[2]

    #f = file_names.pop()
    #image = cv2.imread("./RGBExtractor/image/" + f)
    ROOT_DIR = os.path.abspath("./RGBExtractor/")
    IMAGE_DIR = os.path.join(ROOT_DIR, "image")
    image = cv2.imread(os.path.join(IMAGE_DIR, filename))


    # 채널을 BGR -> RGB로 변경
    image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

    image = image.reshape((image.shape[0] * image.shape[1], 3))  # height, width 통합
    print(image.shape)
    # (25024, 3)

    k = 3  # 예제는 5개로 나누겠습니다
    clt = KMeans(n_clusters=k)
    clt.fit(image)

    for center in clt.cluster_centers_:
        print(center)

    hist = centroid_histogram(clt)
    print(hist)
    # [ 0.68881873  0.09307065  0.14797794  0.04675512  0.02337756]

    # 이중 배열 선언
    resultArray = [[0] * 2 for i in range(3)]
    colorArray = [['black', [15, 15, 15]], ['white', [235, 235, 235]], ['grey', [120, 120, 120]],
                  ['red', [215, 30, 40]], ['pink', [230, 110, 150]], ['orange', [230, 100, 10]],
                  ['beige', [200, 200, 170]], ['brown', [120, 75, 40]], ['yellow', [210, 190, 70]],
                  ['green', [130, 140, 80]],
                  ['blue', [30, 70, 150]], ['skyblue', [185, 206, 235]],
                  ['purple', [120, 80, 170]]
                  ]
    compareArray = [["0"] * 2 for i in range(13)]

    bar = plot_colors(hist, clt.cluster_centers_, resultArray)

    print(resultArray)

    for i in range(3):
        if (resultArray[i][1][0] <= 5 and resultArray[i][1][1] <= 5 and resultArray[i][1][2] <= 5):
            print("")
        else:
            for j in range(13):
                compareArray[j][0] = colorArray[j][0]
                # compareArray[j][1] = abs(resultArray[i][1][0] - colorArray[j][1][0]) + abs(resultArray[i][1][1] - colorArray[j][1][1]) + abs(resultArray[i][1][2] - colorArray[j][1][2])
                compareArray[j][1] = math.sqrt(math.pow((resultArray[i][1][0] - colorArray[j][1][0]), 2) + math.pow((
                        resultArray[i][1][1] - colorArray[j][1][1]), 2) + math.pow(
                    (resultArray[i][1][2] - colorArray[j][1][2]), 2))
            break

    compareArray.sort(key=lambda x: x[1])
    print(compareArray[0][0])

    # show our color bart
    # plt.figure()
    # plt.axis("off")
    # plt.imshow(bar)
    # plt.show()

    return compareArray[0][0]

if __name__ == '__main__':
    main()

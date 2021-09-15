package com.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Getter
@Setter
public class Sample {
    @Id
    ObjectId _id;

    ImageInfo imageInfo;
    DataInfo dataInfo;
}

@Getter
@Setter
class DataInfo {
    private String fileDate;
    DataDetail dataDetail;
    private float fileNum;
    private String fileName;
}

@Getter
@Setter
class DataDetail {
    Rect rect;
    Poligon poligon;
    Labeling labeling;
}

@Getter
@Setter
class Labeling {
    ArrayList < Object > style = new ArrayList < Object > ();
    ArrayList < Object > outer = new ArrayList < Object > ();
    ArrayList < Object > pants = new ArrayList < Object > ();
    ArrayList < Object > onePiece = new ArrayList < Object > ();
    ArrayList < Object > top = new ArrayList < Object > ();
}

@Getter
@Setter
class Poligon {
    ArrayList < Object > outer = new ArrayList < Object > ();
    ArrayList < Object > pants = new ArrayList < Object > ();
    ArrayList < Object > onePiece = new ArrayList < Object > ();
    ArrayList < Object > top = new ArrayList < Object > ();
}

@Getter
@Setter
class Rect {
    ArrayList < Object > outer = new ArrayList < Object > ();
    ArrayList < Object > pants = new ArrayList < Object > ();
    ArrayList < Object > onePiece = new ArrayList < Object > ();
    ArrayList < Object > top = new ArrayList < Object > ();
}

@Getter
@Setter
class ImageInfo {
    float imageId;
    float imageHeight;
    String imageName;
    float imageWidth;
}
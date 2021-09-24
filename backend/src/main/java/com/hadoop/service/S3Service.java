package com.hadoop.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S3Service {

    final static String s3url = "https://j5b206.s3.ap-northeast-2.amazonaws.com/";

    public List<String> GetS3ImageURL(List<String> name){
        List<String> urlList = new ArrayList<>();
        for(int i = 0; i < name.size(); i++){
            urlList.add(new String(s3url+name.get(i)));
        }
        return urlList;
    }
    public String GetS3ImageURL(String name){
        String url = "";
        url = s3url+name;
        return url;
    }
}

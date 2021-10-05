package com.hadoop.api.search.model.service;

import com.hadoop.api.search.model.db.entity.Data;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class S3Service {

    final static String s3url = "https://j5b206.s3.ap-northeast-2.amazonaws.com/";

    public List<String> getS3ImageURL(List<Data> clothes, int page){
        List<String> urlList = new ArrayList<>();
        //Front에서 Page 0, 1, 2 ..... 식으로 보내주면 사진 10개씩 묶어서 전송
//        int pageCount = page * 10;    // clothes도 10개만 가져오는거라 0 부터 시작해도 될 것 같습니다.
        for(int i = 0; i < clothes.size(); i++){
            urlList.add(s3url+ clothes.get(i).getStyle().get(0).getStyle()+ "/" + clothes.get(i).getFileName());
//            if(pageCount == (page*10) + 10)break;
        }
        return urlList;
    }

}

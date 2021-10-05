package com.hadoop.service;

import com.hadoop.entity.CategoryColors;
import com.hadoop.entity.Data;
import com.hadoop.repository.SearchRepository;
import com.hadoop.repository.SearchRepositorySupport;
import com.hadoop.request.ColorStyleReq;
import com.hadoop.request.SearchReq;
import com.hadoop.response.OtherStyleRes;
import com.hadoop.response.SearchRes;
import com.hadoop.response.SimillarStyleRes;
import com.hadoop.common.util.StyleListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    SearchRepositorySupport searchRepositorySupport;

    @Autowired
    StyleListUtil styleListUtil;

    public List<Data> getDatas(SearchReq searchReq){
//        List<Data> jsonArray = searchRepositorySupport.getDoc(searchReq);
        // 여기에 이제 jsonArray에 있는 파일 이름으로 S3 참조해서 이미지 URL 리스트를 가져와서 합치면 될 듯 합니다.
        return searchRepositorySupport.getDoc(searchReq);
    }

    public List<OtherStyleRes> getOtherStyles(String style){

        String category = styleListUtil.styleMap.get(style);
        String[] getted = styleListUtil.styleList.get(category);

        List<OtherStyleRes> list = new ArrayList<>();
        for(int i = 0; i < getted.length; i++){
            if(!style.equals(getted[i])) {
                OtherStyleRes otherStyleRes = new OtherStyleRes();
                otherStyleRes.setCategory(getted[i]);
                otherStyleRes.setUrl(styleListUtil.styleImageMap.get(getted[i]));
                list.add(otherStyleRes);
            }
        }
        return list;
    }

    public List<SimillarStyleRes> getSimillarStyles(String style){
        return searchRepositorySupport.getSimillarStyles(style);
    }

    public List<CategoryColors> getColors(){
        return searchRepositorySupport.getColors();
    }
}

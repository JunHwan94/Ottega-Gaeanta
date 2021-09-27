package com.hadoop.service;

import com.hadoop.entity.Data;
import com.hadoop.repository.SearchRepository;
import com.hadoop.repository.SearchRepositorySupport;
import com.hadoop.request.SearchReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    SearchRepositorySupport searchRepositorySupport;

    public List<Data> getDatas(SearchReq searchReq){
//        List<Data> jsonArray = searchRepositorySupport.getDoc(searchReq);
        // 여기에 이제 jsonArray에 있는 파일 이름으로 S3 참조해서 이미지 URL 리스트를 가져와서 합치면 될 듯 합니다.
        return searchRepositorySupport.getDoc(searchReq);
    }
}

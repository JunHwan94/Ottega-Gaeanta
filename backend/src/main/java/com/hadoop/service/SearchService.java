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
        return searchRepositorySupport.getDoc(searchReq);
    }
}

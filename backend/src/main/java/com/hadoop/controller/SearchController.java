package com.hadoop.controller;

import com.hadoop.entity.Data;
import com.hadoop.repository.SearchRepository;
import com.hadoop.request.SearchReq;
import com.hadoop.service.S3Service;
import com.hadoop.service.SearchService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value="예시")
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @Autowired
    S3Service s3Service;

    @PostMapping("/keyword")
    public List<Data> getDocuments(@RequestBody SearchReq searchReq){
        return searchService.getDatas(searchReq);
    }

    @GetMapping("/s3image")
    public List<String> getS3Image(@RequestBody SearchReq searchReq){
        //searchReq이용하여 searchService에서 Data Entity 정보 가져옴
        List<Data> clothes = searchService.getDatas(searchReq);
        //searchService에서 "Style"과 "FileName"만 사용 + Page count
        List<String> s3url = s3Service.getS3ImageURL(clothes, searchReq.getPage());
        return s3url;
    }
}

package com.hadoop.controller;

import com.hadoop.entity.Data;
import com.hadoop.request.SearchReq;
import com.hadoop.service.S3Service;
import com.hadoop.service.SearchService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/temp")
    public List<String> getImageUrl(@RequestBody ){

    }
}

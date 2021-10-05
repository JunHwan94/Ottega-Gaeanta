package com.hadoop.api.search.controller;

import com.hadoop.api.search.model.response.ColorsRes;
import com.hadoop.api.search.model.response.OtherStyleRes;
import com.hadoop.api.search.model.response.SearchRes;
import com.hadoop.api.search.model.response.SimillarStyleRes;
import com.hadoop.common.model.response.BaseResponseBody;
import com.hadoop.api.search.model.db.entity.Data;
import com.hadoop.api.search.model.request.ColorStyleReq;
import com.hadoop.api.search.model.request.SearchReq;
import com.hadoop.api.search.model.service.S3Service;
import com.hadoop.api.search.model.service.SearchService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="예시")
@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SearchController {

    @Autowired
    SearchService searchService;

    @Autowired
    S3Service s3Service;

    @PostMapping("/keyword")
    public List<Data> getDocuments(@RequestBody SearchReq searchReq){
        return searchService.getDatas(searchReq);
    }

    @PostMapping("/s3image")
    public ResponseEntity<SearchRes> getS3Image(@RequestBody SearchReq searchReq){
        //searchReq이용하여 searchService에서 Data Entity 정보 가져옴
        List<Data> clothes = searchService.getDatas(searchReq);
        //searchService에서 "Style"과 "FileName"만 사용 + Page count
        List<String> s3url = s3Service.getS3ImageURL(clothes, searchReq.getPage());

        SearchRes searchRes = new SearchRes(clothes, s3url);
        return ResponseEntity.ok().body(searchRes);
    }

    @PostMapping("/other")
    public ResponseEntity<List<OtherStyleRes>> getOtherStyle(@RequestBody String style){
        return ResponseEntity.ok(searchService.getOtherStyles(style));
    }

    @GetMapping("/simillar/{style}")
    public ResponseEntity<List<SimillarStyleRes>> getSimillarStyles(@PathVariable String style){
        return ResponseEntity.ok(searchService.getSimillarStyles(style));
    }

    // 카테고리별 색, 프린트 종류 반환하는 api
    @GetMapping("/getColors")
    public ResponseEntity<? extends BaseResponseBody> getColors(){
        return ResponseEntity.ok(ColorsRes.of(200, "성공", searchService.getColors()));
    }
}

package com.hadoop.controller;

import com.hadoop.entity.Data;
import com.hadoop.request.ColorStyleReq;
import com.hadoop.response.EvalColorRes;
import com.hadoop.response.SearchRes;
import com.hadoop.service.EvalService;
import com.hadoop.service.S3Service;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Api(value="색 평가")
@RestController
@RequestMapping("/eval")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EvalController {

    @Autowired
    EvalService evalService;

    @Autowired
    S3Service s3Service;

    @PostMapping(value = "/input")
    public ResponseEntity<EvalColorRes> getInput(@RequestBody MultipartFile image) throws IOException {
        return ResponseEntity.ok().body(evalService.storeImage(image));
    }

    @GetMapping("/getColorStyle/{top}/{bottom}")
    public ResponseEntity<SearchRes> getColorStyle(@PathVariable String top, @PathVariable String bottom){
        ColorStyleReq colorStyleReq = new ColorStyleReq();
        colorStyleReq.setTop(top);
        colorStyleReq.setBottom(bottom);

        List<Data> data = evalService.getColorStyles(colorStyleReq);
        List<String> s3url = s3Service.getS3ImageURL(data, 0);

        return ResponseEntity.ok(new SearchRes(data, s3url));
    }
}

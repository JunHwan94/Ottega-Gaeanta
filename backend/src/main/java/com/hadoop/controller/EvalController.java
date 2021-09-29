package com.hadoop.controller;

import com.hadoop.response.EvalColorRes;
import com.hadoop.service.EvalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Api(value="색 평가")
@RestController
@RequestMapping("/eval")
public class EvalController {

    @Autowired
    EvalService evalService;

    @PostMapping(value = "/input")
    public ResponseEntity<EvalColorRes> getInput(@RequestBody MultipartFile image) throws IOException {
        return ResponseEntity.ok().body(evalService.storeImage(image));
    }
}

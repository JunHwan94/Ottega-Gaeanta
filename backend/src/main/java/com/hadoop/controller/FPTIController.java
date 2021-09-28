package com.hadoop.controller;

import com.hadoop.entity.FPTIType;
import com.hadoop.response.BaseResponseBody;
import com.hadoop.response.FPTIRes;
import com.hadoop.service.FPTIService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fpti")
@AllArgsConstructor
public class FPTIController {

    private final FPTIService fptiService;

    @GetMapping("/result")
    public ResponseEntity<? extends BaseResponseBody> getSurvey(int typeNo){
        FPTIType type = fptiService.getResult(typeNo);
        return ResponseEntity.status(200).body(FPTIRes.of(type));
    }
}

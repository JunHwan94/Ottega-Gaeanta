package com.hadoop.controller;

import com.hadoop.entity.FPTIType;
import com.hadoop.response.BaseResponseBody;
import com.hadoop.response.FPTIRes;
import com.hadoop.service.FPTIService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fpti")
@AllArgsConstructor
@Slf4j
public class FPTIController {

    private final FPTIService fptiService;

    @GetMapping("/result/{typeNo}")
    @ApiOperation(value = "패피티아이 유형 정보", notes = "패피티아이 유형 조회")
    public ResponseEntity<? extends BaseResponseBody> getResult(@PathVariable @ApiParam(value = "패피티아이 유형 번호", required = true) int typeNo){
        FPTIType type = fptiService.getResult(typeNo);
        // log.debug(type.toString());
        // TODO 예외 처리하기 null 등
        return ResponseEntity.status(200).body(FPTIRes.of(200, "성공", type));
    }
}

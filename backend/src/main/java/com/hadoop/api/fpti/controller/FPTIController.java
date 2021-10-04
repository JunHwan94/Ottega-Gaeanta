package com.hadoop.api.fpti.controller;

import com.hadoop.api.fpti.model.entity.FPTISurvey;
import com.hadoop.api.fpti.model.entity.FPTIType;
import com.hadoop.common.model.response.BaseResponseBody;
import com.hadoop.api.fpti.model.response.FPTIRes;
import com.hadoop.api.fpti.model.response.FPTISurveyRes;
import com.hadoop.api.fpti.model.service.FPTIService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fpti")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FPTIController {

    private final FPTIService fptiService;

    @GetMapping("/getSurveys")
    @ApiOperation(value = "패피티아이 질문 리스트", notes = "패피티아이 질문 리스트 조회")
    public ResponseEntity<? extends BaseResponseBody> getSurveys(){
        List<FPTISurvey> surveys = fptiService.getSurveys();
        return ResponseEntity.status(200).body(FPTISurveyRes.of(200, "성공", surveys));
    }

    @GetMapping("/result/{typeNo}")
    @ApiOperation(value = "패피티아이 유형 정보", notes = "패피티아이 유형 조회")
    public ResponseEntity<? extends BaseResponseBody> getResult(@PathVariable @ApiParam(value = "패피티아이 유형 번호", required = true) int typeNo){
        FPTIType type = fptiService.getResult(typeNo);
        // log.debug(type.toString());
        // TODO 예외 처리하기 null 등
        return ResponseEntity.status(200).body(FPTIRes.of(200, "성공", type));
    }

    @PostMapping("/result")
    @ApiOperation(value = "패피티아이 순위 정하기", notes = "패피티아이 순위 정해서 typeNo 반환")
    public ResponseEntity<? extends BaseResponseBody> getArray(@RequestParam(value = "arr[]", required = true) List<Integer> arr){
        int typeNo = fptiService.getTypeNo(arr);
        FPTIType type = fptiService.getResult(typeNo);
        return ResponseEntity.status(200).body(FPTIRes.of(200, "성공", type));
    }

}

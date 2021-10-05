package com.hadoop.api.fpti.model.service;

import com.hadoop.api.fpti.model.entity.FPTISurvey;
import com.hadoop.api.fpti.model.entity.FPTIType;

import java.util.List;
import java.util.Optional;

public interface FPTIService {
    List<FPTISurvey> getSurveys();
    Optional<FPTIType> getResult(int typeNo);
    int getTypeNo(List<Integer> array);
}

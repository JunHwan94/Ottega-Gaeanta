package com.hadoop.api.fpti.model.service;

import com.hadoop.api.fpti.model.entity.FPTISurvey;
import com.hadoop.api.fpti.model.entity.FPTIType;

import java.util.List;

public interface FPTIService {
    List<FPTISurvey> getSurveys();
    FPTIType getResult(int typeNo);
    int getTypeNo(List<Integer> array);
}

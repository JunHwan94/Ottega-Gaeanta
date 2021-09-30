package com.hadoop.service;

import com.hadoop.entity.FPTISurvey;
import com.hadoop.entity.FPTIType;

import java.util.List;

public interface FPTIService {
    List<FPTISurvey> getSurveys();
    FPTIType getResult(int typeNo);
    int getTypeNo(List<Integer> array);
}

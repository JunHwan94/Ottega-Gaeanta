package com.hadoop.api.fpti.model.service;

import com.hadoop.api.fpti.model.entity.FPTISurvey;
import com.hadoop.api.fpti.model.entity.FPTIType;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FPTIServiceImpl implements FPTIService{

    private final MongoTemplate mongoTemplate;

    @Override
    public List<FPTISurvey> getSurveys() {
        return mongoTemplate.findAll(FPTISurvey.class);
    }

    @Override
    public Optional<FPTIType> getResult(int typeNo) {
        return Optional.ofNullable(
                mongoTemplate.findOne(
                        Query.query(Criteria.where("typeno").is(typeNo)),
                        FPTIType.class
                )
        );
    } 

    @Override
    public int getTypeNo(List<Integer> array){
        int max = 0;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) > max) max = array.get(i);
        }
        List<Integer> maxResult = new ArrayList<>();
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) == max)maxResult.add(i+1);
        }
        if(maxResult.size() == 1) return maxResult.get(0);
        else{
            Collections.shuffle(maxResult);
            return maxResult.get(0);
        }
    }
}

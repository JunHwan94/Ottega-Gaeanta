package com.hadoop.service;

import com.hadoop.entity.FPTISurvey;
import com.hadoop.entity.FPTIType;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class FPTIServiceImpl implements FPTIService{

    private final MongoTemplate mongoTemplate;

    @Override
    public List<FPTISurvey> getSurveys() {
        return mongoTemplate.findAll(FPTISurvey.class);
    }

    @Override
    public FPTIType getResult(int typeNo) {
        return mongoTemplate.findOne(
                Query.query(Criteria.where("typeno").is(typeNo)),
                FPTIType.class
        );
    }

    @Override
    public int getTypeNo(List<Integer> array){
        Collections.sort(array);
        int max = array.get(array.size()-1);
        List<Integer> maxResult = new ArrayList<>();
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) == max)maxResult.add(array.get(i));
        }
        if(maxResult.size() == 1) return maxResult.get(0);
        else{
            Collections.shuffle(maxResult);
            return maxResult.get(0);
        }
    }
}

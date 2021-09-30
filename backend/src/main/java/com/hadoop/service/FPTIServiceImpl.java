package com.hadoop.service;

import com.hadoop.entity.FPTISurvey;
import com.hadoop.entity.FPTIType;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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
                Query.query(Criteria.where("typeNo").is(typeNo)),
                FPTIType.class
        );
    }
}

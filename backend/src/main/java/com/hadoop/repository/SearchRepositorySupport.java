package com.hadoop.repository;

import com.hadoop.entity.Data;
import com.hadoop.request.SearchReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class SearchRepositorySupport {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Data> getDoc(SearchReq searchReq){
        Query query = new Query(where(searchReq.getCloth() + ".category").is(searchReq.getCategory())
            .and(searchReq.getCloth() + ".color").is(searchReq.getColor())
            .and(searchReq.getCloth() + ".print").is(searchReq.getPrint())
        );
        return mongoTemplate.find(query.limit(10), Data.class);
    }
}
package com.hadoop.repository;

import com.hadoop.entity.Data;
import com.hadoop.request.SearchReq;
import com.mongodb.BasicDBObject;
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
        Query query = null;
        if(searchReq.getColor().equals("")){
            query = new Query(where(searchReq.getCloth() + ".category").is(searchReq.getCategory())
                    .and(searchReq.getCloth() + ".print").is(searchReq.getPrint())
            ).skip(searchReq.getPage()*20);
        } else if (searchReq.getPrint().equals("")){
            query = new Query(where(searchReq.getCloth() + ".category").is(searchReq.getCategory())
                    .and(searchReq.getCloth() + ".print").is(searchReq.getPrint())
            ).skip(searchReq.getPage()*20);
        } else {
            query = new Query(where(searchReq.getCloth() + ".category").is(searchReq.getCategory())
                    .and(searchReq.getCloth() + ".color").is(searchReq.getColor())
                    .and(searchReq.getCloth() + ".print").is(searchReq.getPrint())
            ).skip(searchReq.getPage()*20);
        }
        return mongoTemplate.find(query.limit(20), Data.class);
    }
}
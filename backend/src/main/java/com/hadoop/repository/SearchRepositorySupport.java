package com.hadoop.repository;

import com.hadoop.entity.Data;
import com.hadoop.request.SearchReq;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
                    .and(searchReq.getCloth() + ".print").all(searchReq.getPrint())
                    .and("style.style").in(searchReq.getStyle())
            ).skip(searchReq.getPage()*10);
        } else if (searchReq.getPrint().equals("")){
            query = new Query(where(searchReq.getCloth() + ".category").is(searchReq.getCategory())
                    .and(searchReq.getCloth() + ".color").all(searchReq.getColor())
                    .and("style.style").in(searchReq.getStyle())
            ).skip(searchReq.getPage()*10);
        } else {
            query = new Query(where(searchReq.getCloth() + ".category").is(searchReq.getCategory())
                    .and(searchReq.getCloth() + ".color").all(searchReq.getColor())
                    .and(searchReq.getCloth() + ".print").all(searchReq.getPrint())
                    .and("style.style").in(searchReq.getStyle())
            ).skip(searchReq.getPage()*10);
        }
        return mongoTemplate.find(query.limit(10), Data.class);
    }
}
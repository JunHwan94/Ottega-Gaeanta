package com.hadoop.api.eval.model.db.repository;

import com.hadoop.api.eval.model.db.entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class EvalRepositorySupport {

    @Autowired
    MongoTemplate mongoTemplate;

    public Rank getRank(String key) {
        Query query = new Query(where("key").is(key));
        return mongoTemplate.findOne(query, Rank.class);
    }
}

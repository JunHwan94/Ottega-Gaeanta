package com.example.repository;

import com.example.entity.Data;
import com.example.entity.Person;
import com.example.entity.Sample;
import com.example.request.SearchReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class TestRepositorySupport {

    @Autowired
    MongoTemplate mongoTemplate;

    public void insertInfo(String name, String job){
        Person person = Person.builder().name(name).job(job).build();
        mongoTemplate.insert(person);
    }

    public Sample findOne(String name){
        Query query = new Query(where("name").is("정범진"));
        return mongoTemplate.findOne(query, Sample.class);
    }

    public List<Data> getDoc(SearchReq searchReq){
        Query query = new Query(where(searchReq.getCloth() + ".categori").is(searchReq.getCategori())
            .and(searchReq.getCloth() + ".color").is(searchReq.getColor())
            .and(searchReq.getCloth() + ".print").is(searchReq.getPrint())
        );
        return mongoTemplate.find(query, Data.class).subList(0, 10);
    }
}
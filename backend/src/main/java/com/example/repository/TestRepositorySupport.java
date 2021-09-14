package com.example.repository;

import com.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class TestRepositorySupport {

    @Autowired
    MongoTemplate mongoTemplate;

    public void insertInfo(String name, String job){
        Person person = Person.builder().name(name).job(job).build();
        mongoTemplate.insert(person);
    }

    public Person findOne(String name){
        Query query = new Query(where("name").is("정범진"));
        return mongoTemplate.findOne(query, Person.class);
    }
}

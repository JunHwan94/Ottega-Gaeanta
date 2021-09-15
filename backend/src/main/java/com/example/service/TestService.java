package com.example.service;

import com.example.entity.Data;
import com.example.entity.Person;
import com.example.entity.Sample;
import com.example.repository.TestRepository;
import com.example.repository.TestRepository2;
import com.example.repository.TestRepositorySupport;
import com.example.request.SearchReq;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestRepository2 testRepository2;

    @Autowired
    TestRepositorySupport testRepositorySupport;

    public List<Person> getAll(){
        return testRepository.findAll();
    }

    public void insert(String name, String job){
        testRepositorySupport.insertInfo(name, job);
    }

    public Sample getOne(){
        return testRepositorySupport.findOne("정범진");
    }

    public List<Data> getAll2() { return testRepository2.findAll(); }

    public List<Data> getDatas(SearchReq searchReq){
        return testRepositorySupport.getDoc(searchReq);
    }
}

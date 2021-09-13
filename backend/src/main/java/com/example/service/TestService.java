package com.example.service;

import com.example.entity.Person;
import com.example.repository.TestRepository;
import com.example.repository.TestRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestRepositorySupport testRepositorySupport;

    public List<Person> getAll(){
        return testRepository.findAll();
    }

    public void insert(String name, String job){
        testRepositorySupport.insertInfo(name, job);
    }

    public Person getOne(){
        return testRepositorySupport.findOne("정범진");
    }
}

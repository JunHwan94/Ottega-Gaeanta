package com.example.controller;

import com.example.entity.Person;
import com.example.service.TestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value="예시")
@RestController
public class testController {

    @Autowired
    TestService testService;

    @GetMapping("/mongo")
    public List<Person> getAll(){
        return testService.getAll();
    }

    @GetMapping("/mongo/{name}/{job}")
    public void insertInfo(@PathVariable String name, @PathVariable String job){
        testService.insert(name, job);
    }

    @GetMapping("/mongo/getOne")
    public Person getOne(){
        return testService.getOne();
    }
}

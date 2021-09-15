package com.example.controller;

import com.example.entity.Data;
import com.example.entity.Person;
import com.example.entity.Sample;
import com.example.request.SearchReq;
import com.example.service.TestService;
import com.mongodb.client.FindIterable;
import io.swagger.annotations.Api;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="예시")
@RestController
@RequestMapping("/search")
public class searchController {

    @Autowired
    TestService testService;

    @PostMapping("/keyword")
    public List<Data> getDocuments(@RequestBody SearchReq searchReq){
        return testService.getDatas(searchReq);
    }
}

package com.example.repository;

import com.example.entity.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository2 extends MongoRepository<Data, String> {
}

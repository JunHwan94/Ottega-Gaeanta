package com.hadoop.repository;

import com.hadoop.entity.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchRepository extends MongoRepository<Data, String> {
}

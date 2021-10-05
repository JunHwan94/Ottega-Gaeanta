package com.hadoop.api.search.model.db.repository;

import com.hadoop.api.search.model.db.entity.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchRepository extends MongoRepository<Data, String> {
}

package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
@NoArgsConstructor
public class Person {

    @Id
    ObjectId _id;

    String name;
    String job;

    @Builder
    public Person(String name, String job){
        this.name = name;
        this.job = job;
    }
}

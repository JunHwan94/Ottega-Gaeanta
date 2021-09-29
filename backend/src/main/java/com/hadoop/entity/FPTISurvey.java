package com.hadoop.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@Document(collection = "fpti_survey")
public class FPTISurvey {
    private int qno;
    private String question;
    private Set<String> answerList;
}
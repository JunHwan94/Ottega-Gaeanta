package com.hadoop.api.fpti.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@Document(collection = "fpti_surveys")
public class FPTISurvey {
    private int qno;
    private String iconUrl;
    private String question;
    private Set<String> answerList;
}
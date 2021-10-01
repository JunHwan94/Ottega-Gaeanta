package com.hadoop.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Data
@Document(collection = "fpti_types")
public class FPTIType {
    private Integer typeNo;
    private String fptiName;
    private String title;
    private String desc;
    private String comment;
    private String iconUrl;
    private Set<String> bgImgUrl;
    private Set<String> hashtag;
}

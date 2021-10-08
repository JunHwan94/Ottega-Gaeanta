package com.hadoop.api.fpti.model.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "fpti_types")
public class FPTIType {
    private Integer typeno;
    private String fptiName;
    private String title;
    private String desc;
    private String comment;
    private String iconUrl;
    private Set<String> bgImgUrl;
    private Set<String> hashtag;
}

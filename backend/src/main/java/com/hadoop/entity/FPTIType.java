package com.hadoop.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "fpti_types")
public class FPTIType {
    private Integer typeNo;
    private String fptiName;
    private String desc;
    private String iconUrl;
    private String bgImgUrl;
}

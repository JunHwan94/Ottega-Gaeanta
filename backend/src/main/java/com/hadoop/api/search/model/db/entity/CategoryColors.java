package com.hadoop.api.search.model.db.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@Document("colors")
public class CategoryColors {
    private String category;
    private Set<String> colors;
}

package com.hadoop.api.eval.model.db.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
@Document(collection = "rank_desc")
public class RankDesc {
    String rank;
    String desc;
    Set<String> hashtag;
}

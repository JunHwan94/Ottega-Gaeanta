package com.hadoop.api.eval.model.db.entity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
public class RankDesc {
    String rank;
    String desc;
    Set<String> hashtag;
}

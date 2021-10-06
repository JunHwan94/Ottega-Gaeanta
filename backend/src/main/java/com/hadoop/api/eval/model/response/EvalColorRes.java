package com.hadoop.api.eval.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class EvalColorRes {
    String top;
    String pants;
    String rank;
    String desc;
    Set<String> hashtag;
}

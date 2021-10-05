package com.hadoop.api.search.model.db.entity;

import com.hadoop.api.search.model.response.SimillarStyleRes;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class SimillarStyle {
    String cg;
    ArrayList<SimillarStyleRes> stlist = new ArrayList<>();
}

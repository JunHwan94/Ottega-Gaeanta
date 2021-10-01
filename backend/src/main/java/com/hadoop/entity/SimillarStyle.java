package com.hadoop.entity;

import com.hadoop.response.SimillarStyleRes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Getter
@Setter
public class SimillarStyle {
    String cg;
    ArrayList<SimillarStyleRes> stlist = new ArrayList<>();
}

package com.hadoop.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class SearchReq {
    String cloth;
    String category;
    String color;
    String print;
    String[] style;
    int page;
}

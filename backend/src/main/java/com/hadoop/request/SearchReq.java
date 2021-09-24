package com.hadoop.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchReq {
    String cloth;
    String category;
    String color;
    String print;
    int page;
}

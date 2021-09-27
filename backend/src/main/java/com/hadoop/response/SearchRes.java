package com.hadoop.response;

import com.hadoop.entity.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SearchRes {

    List<Data> clothes;
    List<String> s3url;
}

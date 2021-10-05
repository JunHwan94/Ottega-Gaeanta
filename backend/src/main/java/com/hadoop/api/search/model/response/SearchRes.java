package com.hadoop.api.search.model.response;

import com.hadoop.api.search.model.db.entity.Data;
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

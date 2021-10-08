package com.hadoop.api.search.model.db.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Data {
    ArrayList <Style> style = new ArrayList < Style > ();
    ArrayList < Object > outer = new ArrayList < Object > ();
    ArrayList < Object > bottom = new ArrayList < Object > ();
    ArrayList < Object > onepiece = new ArrayList < Object > ();
    ArrayList < Object > top = new ArrayList < Object > ();
    private float fileNo;
    private String fileName;
}
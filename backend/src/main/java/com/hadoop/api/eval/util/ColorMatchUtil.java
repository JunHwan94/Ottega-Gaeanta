package com.hadoop.api.eval.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ColorMatchUtil {

    public Map<String, String> colorMap = new HashMap<>();

    @PostConstruct
    public void initColorMap(){
        colorMap.put("black", "블랙");
        colorMap.put("white", "화이트");
        colorMap.put("grey", "그레이");
        colorMap.put("pink", "핑크");
        colorMap.put("red", "레드");
        colorMap.put("blue", "블루");
        colorMap.put("skyblue", "스카이블루");
        colorMap.put("green", "그린");
        colorMap.put("beige", "베이지");
        colorMap.put("yellow", "옐로우");
        colorMap.put("orange", "오렌지");
        colorMap.put("purple", "퍼플");
        colorMap.put("brown", "브라운");

    }
}


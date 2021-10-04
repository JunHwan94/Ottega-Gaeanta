package com.hadoop.response;

import com.hadoop.common.model.response.BaseResponseBody;
import com.hadoop.entity.CategoryColors;
import lombok.Getter;

import java.util.List;

@Getter
public class ColorsRes extends BaseResponseBody {
    private List<CategoryColors> colors;

    private ColorsRes(){}

    public static ColorsRes of(int statusCode, String message, List<CategoryColors> colors){
        ColorsRes res = new ColorsRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.colors = colors;
        return res;
    }
}

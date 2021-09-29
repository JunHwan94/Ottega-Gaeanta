package com.hadoop.response;

import com.hadoop.entity.FPTIType;
import lombok.Getter;

@Getter
public class FPTIRes extends BaseResponseBody{

    private FPTIType type;

    private FPTIRes(){}

    public static FPTIRes of(int statusCode, String message, FPTIType type){
        FPTIRes res = new FPTIRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.type = type;
        return res;
    }
}

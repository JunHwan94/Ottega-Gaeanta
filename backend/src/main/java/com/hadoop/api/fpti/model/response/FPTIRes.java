package com.hadoop.api.fpti.model.response;

import com.hadoop.api.fpti.model.entity.FPTIType;
import com.hadoop.common.model.response.BaseResponseBody;
import lombok.Getter;

@Getter
public class FPTIRes extends BaseResponseBody {

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

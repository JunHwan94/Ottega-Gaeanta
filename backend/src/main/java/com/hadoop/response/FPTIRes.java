package com.hadoop.response;

import com.hadoop.entity.FPTIType;

public class FPTIRes extends BaseResponseBody{
    private static class ResHolder{
        private static final FPTIRes res = new FPTIRes();
    }

    private FPTIType type;

    private FPTIRes(){}

    public static FPTIRes of(int statusCode, String message, FPTIType type){
        ResHolder.res.setStatusCode(statusCode);
        ResHolder.res.setMessage(message);
        ResHolder.res.type = type;
        return ResHolder.res;
    }
}

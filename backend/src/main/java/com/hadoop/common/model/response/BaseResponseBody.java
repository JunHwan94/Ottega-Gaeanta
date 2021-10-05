package com.hadoop.common.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseBody {
    @ApiModelProperty(name="응답 메세지", example = "정상")
    private String message = null;

    @ApiModelProperty(name="응답 코드", example = "200")
    private Integer statusCode = null;

    public BaseResponseBody(){}

    public BaseResponseBody(Integer statusCode){
        this.statusCode = statusCode;
    }

    public BaseResponseBody(String message, Integer statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }

    public static BaseResponseBody of(Integer statusCode, String message){
        BaseResponseBody body = new BaseResponseBody();
        body.message = message;
        body.statusCode = statusCode;
        return body;
    }
}

package com.hadoop.api.fpti.model.response;

import com.hadoop.api.fpti.model.entity.FPTISurvey;
import com.hadoop.common.model.response.BaseResponseBody;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FPTISurveyRes extends BaseResponseBody {

    private List<FPTISurvey> surveys;

    private FPTISurveyRes(){}

    public static FPTISurveyRes of(int statusCode, String message, List<FPTISurvey> surveys){
        FPTISurveyRes res = new FPTISurveyRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.surveys = surveys;
        return res;
    }
}

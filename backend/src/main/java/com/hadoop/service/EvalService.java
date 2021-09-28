package com.hadoop.service;
import com.hadoop.entity.ColorRank;
import com.hadoop.response.EvalColorRes;
import com.hadoop.util.ColorRankUtil;
import com.hadoop.util.FileUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Service
public class EvalService {

    @Autowired
    ColorRankUtil colorRankUtil;

    public EvalColorRes storeImage(MultipartFile image) throws IOException {
        FileUtil fileUtil = FileUtil.getInstance();

        File t = new File("..");
        String path = t.getCanonicalPath() + "/file";

        File file = new File(path + ".jpg");
        image.transferTo(file);

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("file", new FileSystemResource("../file.jpg"));

        HttpHeaders headers = new HttpHeaders();
//        headers.add("Accept", MediaType.APPLICATION_JSON.toString());   // json 결과 String으로 변환해서 가져오기는 하는데 흠
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<ColorRank> response = null;

        try {
            response = rt.postForEntity(
                    "http://j5b206.p.ssafy.io:8888/model",
                    entity,
                    ColorRank.class
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        String top = response.getBody().getTop();
        String pants = response.getBody().getPants();

        String key = top + ":" + pants;

        EvalColorRes evalColorRes = new EvalColorRes(top, pants, colorRankUtil.rank.get(key));
        return evalColorRes;
    }


}

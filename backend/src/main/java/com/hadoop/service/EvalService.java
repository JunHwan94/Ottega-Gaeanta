package com.hadoop.service;
import com.hadoop.util.FileUtil;
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
    public ResponseEntity<String> storeImage(MultipartFile image) throws IOException {
        FileUtil fileUtil = FileUtil.getInstance();

        File t = new File("..");
        String path = t.getCanonicalPath() + "/file";

        File file = new File(path + ".jpg");
        image.transferTo(file);

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("file", new FileSystemResource("../file.jpg"));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());   // json 결과 String으로 변환해서 가져오기는 하는데 흠
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = null;

        try {
            response = rt.postForEntity(
                    "http://j5b206.p.ssafy.io:8888/model",
                    entity,
                    String.class
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


}

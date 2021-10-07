package com.hadoop.api.eval.model.service;
import com.hadoop.api.eval.model.db.entity.ColorRank;
import com.hadoop.api.eval.model.db.entity.Rank;
import com.hadoop.api.eval.model.db.entity.RankDesc;
import com.hadoop.api.eval.model.db.repository.EvalRepositorySupport;
import com.hadoop.api.eval.model.response.EvalColorRes;
import com.hadoop.api.eval.util.ColorMatchUtil;
import com.hadoop.api.search.model.db.entity.Data;
import com.hadoop.api.search.model.request.ColorStyleReq;
import com.hadoop.common.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
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
import java.util.List;

@Slf4j
@Service
public class EvalService {

    @Autowired
    EvalRepositorySupport evalRepositorySupport;

    @Autowired
    ColorMatchUtil colorMatchUtil;

    public EvalColorRes storeImage(MultipartFile image) throws IOException {
        FileUtil fileUtil = FileUtil.getInstance();

        File t = new File("..");
        String path = t.getCanonicalPath() + "/file";

        File file = new File(path + ".jpg");
        image.transferTo(file);

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("file", new FileSystemResource("../file.jpg"));

        log.debug(image.getOriginalFilename());

        HttpHeaders headers = new HttpHeaders();
//        headers.add("Accept", MediaType.APPLICATION_JSON.toString());   // json 결과 String으로 변환해서 가져오기는 하는데 흠
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<ColorRank> response = null;

        try {
            System.out.println("Server Connection");
            response = rt.postForEntity(
                    // 백준님 개인 flask URL 주소입니다.
                    "http://3.38.125.201:8888/model",
                    entity,
                    ColorRank.class
            );


            String top = response.getBody().getTop();
            String pants = response.getBody().getPants();

            log.debug("top : " + top);
            log.debug("pants : " + pants);

            String key = top + "-" + pants;

            Rank rank = evalRepositorySupport.getRank(key);
            RankDesc rankDesc = evalRepositorySupport.getDesc(rank.getValue());
            System.err.println(rankDesc.getDesc());
            System.out.println(rankDesc.getHashtag());

            System.out.println(rank.getKey());
            System.out.println(rank.getValue());
            System.out.println(top);
            System.out.println(pants);
            System.out.println(rankDesc.getDesc());
            System.out.println(rankDesc.getHashtag());
            System.out.println(rankDesc.getDesc());

            EvalColorRes evalColorRes = new EvalColorRes(colorMatchUtil.colorMap.get(top), colorMatchUtil.colorMap.get(pants), rank.getValue(), rankDesc.getDesc(), rankDesc.getHashtag());

            return evalColorRes;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Data> getColorStyles(ColorStyleReq colorStyleReq) {
        return evalRepositorySupport.getColorStyles(colorStyleReq);
    }
}

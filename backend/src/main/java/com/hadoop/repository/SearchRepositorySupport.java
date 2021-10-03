package com.hadoop.repository;

import com.hadoop.entity.Data;
import com.hadoop.entity.SimillarStyle;
import com.hadoop.request.SearchReq;
import com.hadoop.response.SimillarStyleRes;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class SearchRepositorySupport {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Data> getDoc(SearchReq searchReq){
        Query query = null;

        if(searchReq.getCloth().equals("")){
          query = new Query(where("style.style").in(searchReq.getStyle())).skip(searchReq.getPage()*20);
        } else if(searchReq.getColor().equals("")){
            query = new Query(where(searchReq.getCloth() + ".category").is(searchReq.getCategory())
                    .and(searchReq.getCloth() + ".print").all(searchReq.getPrint())
                    .and("style.style").in(searchReq.getStyle())
            ).skip(searchReq.getPage()*20);
        } else if (searchReq.getPrint().equals("")){
            query = new Query(where(searchReq.getCloth() + ".category").is(searchReq.getCategory())
                    .and(searchReq.getCloth() + ".color").all(searchReq.getColor())
                    .and("style.style").in(searchReq.getStyle())
            ).skip(searchReq.getPage()*20);
        } else {
            query = new Query(where(searchReq.getCloth() + ".category").is(searchReq.getCategory())
                    .and(searchReq.getCloth() + ".color").all(searchReq.getColor())
                    .and(searchReq.getCloth() + ".print").all(searchReq.getPrint())
                    .and("style.style").in(searchReq.getStyle())
            ).skip(searchReq.getPage()*20);
        }
        return mongoTemplate.find(query.limit(20), Data.class);
    }

    public List<SimillarStyleRes> getSimillarStyles(String toStyle){

        System.out.println(toStyle);
        Query query = new Query(where("stlist.stname").is(toStyle));
        SimillarStyle list = mongoTemplate.findOne(query, SimillarStyle.class);

        List<SimillarStyleRes> results = new ArrayList<>();

        for(int i = 0; i < list.getStlist().size(); i++){
            if(!list.getStlist().get(i).getStname().equals(toStyle)){
                SimillarStyleRes res = new SimillarStyleRes();
                res.setStname(list.getStlist().get(i).getStname());
                res.setSturl(list.getStlist().get(i).getSturl());
                results.add(res);
            }
        }
        return results;
    }

}
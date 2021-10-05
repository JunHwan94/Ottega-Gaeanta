package com.hadoop.repository;

import com.hadoop.entity.CategoryColors;
import com.hadoop.entity.Data;
import com.hadoop.entity.SimillarStyle;
import com.hadoop.request.ColorStyleReq;
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

    public List<CategoryColors> getColors(){
        return mongoTemplate.findAll(CategoryColors.class);
    }

    public List<Data> getColorStyles(ColorStyleReq colorStyleReq){

        int page = 0;
        Query query = new Query(
                where("top.color").all(colorStyleReq.getTop())
                .and("bottom.color").all(colorStyleReq.getBottom())
        ).skip(page * 20);

        List<Data> result = new ArrayList<>();

        outer : while(true){
            List<Data> list = mongoTemplate.find(query, Data.class);

            for(int i = 0; i < list.size(); i++){
                if(i == 0) {
                    result.add(list.get(i));
                } else {
                    if(!result.get(result.size() - 1).getStyle().get(0).getStyle().equals(list.get(i).getStyle().get(0).getStyle())){
                        result.add(list.get(i));
                    }
                }
                if(result.size() == 4) break outer;
            }
            page++;
            System.out.println(result.size());
        }
        return result;
    }
}
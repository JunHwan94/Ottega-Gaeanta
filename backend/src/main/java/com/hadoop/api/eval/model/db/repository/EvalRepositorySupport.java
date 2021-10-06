package com.hadoop.api.eval.model.db.repository;

import com.hadoop.api.eval.model.db.entity.Rank;
import com.hadoop.api.eval.model.db.entity.RankDesc;
import com.hadoop.api.search.model.db.entity.Data;
import com.hadoop.api.search.model.request.ColorStyleReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class EvalRepositorySupport {

    @Autowired
    MongoTemplate mongoTemplate;

    public Rank getRank(String key) {
        Query query = new Query(where("key").is(key));
        return mongoTemplate.findOne(query, Rank.class);
    }

    public RankDesc getDesc(String rank){
        Query query = new Query(where("rank").is(rank));
        return mongoTemplate.findOne(query, RankDesc.class);
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

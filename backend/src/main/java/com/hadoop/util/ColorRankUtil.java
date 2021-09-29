package com.hadoop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class ColorRankUtil {

    public static Map<String, String> rank = new HashMap<>();

    @PostConstruct
    public void initRank(){

        try {
            File file = new File(System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() - 7) + "\\rank.txt");
            System.out.println("init 실행");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            while((line = br.readLine()) != null){
                String[] a = line.split("/");
                String key = a[0];
                String value = a[1];
                rank.put(key, value);
                System.out.println(rank.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

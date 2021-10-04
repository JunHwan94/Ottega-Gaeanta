package com.hadoop.common.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Component
public class StyleListUtil {

    public static Map<String, String[]> styleList = new HashMap<>();
    public static Map<String, String> styleMap = new HashMap<>();
    public static Map<String, String> styleImageMap = new HashMap<>();

    @PostConstruct
    public void initStyleList(){
        try {
            File file = new File("../stylelist.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            while((line = br.readLine()) != null){
                String[] splitList = line.split("/");
                String[] list = splitList[1].split(",");

                for(int i = 0; i < list.length; i++){
                    styleMap.put(list[i], splitList[0]);
                }
                styleList.put(splitList[0], list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void initStyleImageList(){
        try {
            File file = new File("../styleImageUrl.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            while((line = br.readLine()) != null){
                String[] splitList = line.split(",");
                styleImageMap.put(splitList[0], splitList[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.hadoop.common.util;

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

    File styleFile = new File("../stylelist.txt");
    File urlFile = new File("../styleImageUrl.txt");


}

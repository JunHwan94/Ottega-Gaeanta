package com.hadoop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HadoopApplication {
	public static void main(String[] args) {
		SpringApplication.run(HadoopApplication.class, args);
	}
}

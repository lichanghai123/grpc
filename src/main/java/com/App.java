package com;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@MapperScan("com.mapper")
public class App {
	
    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class,args);
    }
}


package com.example.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chunbo.ma.o
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.example.**.domain.mapper"})
public class McbTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(McbTestApplication.class, args);
    }

}

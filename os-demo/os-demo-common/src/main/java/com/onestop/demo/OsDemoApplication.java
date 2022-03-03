package com.onestop.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Clark
 * @version 2021/08/04
 */
@EnableAsync //开启异步调用
@SpringBootApplication
@ComponentScan("com.onestop")
@MapperScan("com.onestop.**.mapper")
public class OsDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(OsDemoApplication.class, args);
    }
}
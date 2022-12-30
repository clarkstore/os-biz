package com.onestop.demo.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Clark
 * @version 2021/08/04
 */
//开启异步
@EnableAsync
@SpringBootApplication
@ComponentScan("com.onestop")
@MapperScan("com.onestop.**.mapper")
public class OsLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(OsLogApplication.class, args);
    }
}
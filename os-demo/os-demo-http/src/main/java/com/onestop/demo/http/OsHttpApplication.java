package com.onestop.demo.http;

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
public class OsHttpApplication {
    public static void main(String[] args) {
        SpringApplication.run(OsHttpApplication.class, args);
    }
}
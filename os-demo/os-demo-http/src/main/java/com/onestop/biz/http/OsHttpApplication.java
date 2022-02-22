package com.onestop.biz.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Clark
 * @version 2021/08/04
 */
@SpringBootApplication
@ComponentScan("com.onestop")
public class OsHttpApplication {
    public static void main(String[] args) {
        SpringApplication.run(OsHttpApplication.class, args);
    }
}
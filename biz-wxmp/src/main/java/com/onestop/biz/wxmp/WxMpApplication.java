package com.onestop.biz.wxmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.onestop")
public class WxMpApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxMpApplication.class, args);
    }
}


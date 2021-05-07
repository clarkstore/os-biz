package com.onestop.biz.wxmini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.onestop")
public class WxMiniApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxMiniApplication.class, args);
    }
}


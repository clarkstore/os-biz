package com.onestop.biz.mq.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.onestop")
@MapperScan({"com.onestop.**.mapper"})
public class Msg2Application {
    public static void main(String[] args) {
        SpringApplication.run(Msg2Application.class, args);
    }
}


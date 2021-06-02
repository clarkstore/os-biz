package com.onestop.biz.mq.consumer.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.onestop")
//@MapperScan({"com.onestop.**.mapper"})
public class MsgProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsgProducerApplication.class, args);
    }
}


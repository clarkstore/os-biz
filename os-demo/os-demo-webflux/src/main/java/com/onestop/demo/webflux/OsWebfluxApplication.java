package com.onestop.demo.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author Clark
 * @version 2023/01/12
 */
@EnableWebFlux
@SpringBootApplication
@ComponentScan("com.onestop")
public class OsWebfluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(OsWebfluxApplication.class, args);
    }
}
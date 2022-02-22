package com.onestop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Clark
 * @version 2021/08/04
 */
@SpringBootApplication
@ComponentScan("com.onestop")
public class OsDemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(OsDemoApplication.class, args);
  }
}
package com.onestop.biz.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Clark
 * @version 2021/7/22
 */
@SpringBootApplication
@ComponentScan("com.onestop")
public class BizCommonApplication {
  public static void main(String[] args) {
    SpringApplication.run(BizCommonApplication.class, args);
  }
}
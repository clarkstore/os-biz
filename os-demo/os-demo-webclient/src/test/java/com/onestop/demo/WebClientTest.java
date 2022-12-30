package com.onestop.demo;

import com.onestop.demo.webclient.WebClientApplication;
import com.onestop.demo.webclient.api.WebClientApi;
import com.onestop.demo.webclient.dto.ReqDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Clark
 * @version 2021/9/13
 */
@SpringBootTest(classes = WebClientApplication.class)
public class WebClientTest {
    @Autowired
    private WebClientApi webClientDemo;

    @Test
    public void get() {
        webClientDemo.get("/get/123");
        ReqDto dto = ReqDto.builder()
                .id("123")
                .name("张三").build();
        webClientDemo.post(dto);
    }
}
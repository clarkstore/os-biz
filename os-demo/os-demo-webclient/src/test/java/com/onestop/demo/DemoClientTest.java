package com.onestop.demo;

import com.onestop.demo.webclient.WebClientApplication;
import com.onestop.demo.webclient.api.DemoClientApi;
import com.onestop.demo.webclient.dto.ReqDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Clark
 * @version 2021/9/13
 */
@SpringBootTest(classes = WebClientApplication.class)
public class DemoClientTest {
    @Autowired
    private DemoClientApi demoClientApi;

    @Test
    public void get() {
        demoClientApi.get("123");
    }

    @Test
    public void post() {
        ReqDto dto = ReqDto.builder()
                .id("123")
                .name("张三").build();
        demoClientApi.post(dto);
    }
}
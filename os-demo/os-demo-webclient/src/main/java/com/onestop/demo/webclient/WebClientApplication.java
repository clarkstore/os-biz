package com.onestop.demo.webclient;

import com.onestop.demo.webclient.api.DemoClientApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author Clark
 * @version 2022-12-30
 */
@Slf4j
@SpringBootApplication
@ComponentScan("com.onestop")
public class WebClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebClientApplication.class, args);
    }

    @Bean
    DemoClientApi demoClientApi() {
        WebClient client = WebClient.builder().baseUrl("http://localhost:8888/").build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(DemoClientApi.class);
    }
}
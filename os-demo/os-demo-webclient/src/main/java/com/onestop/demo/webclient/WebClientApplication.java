package com.onestop.demo.webclient;

import com.onestop.demo.webclient.api.DemoClient;
import com.onestop.demo.webclient.api.TimeClient;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author Clark
 * @version 2022-12-30
 */
@EnableWebFlux
@SpringBootApplication
@ComponentScan("com.onestop")
public class WebClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebClientApplication.class, args);
    }

    private WebClient client = WebClient.builder().baseUrl("http://localhost/").build();

    @SneakyThrows
    @Bean
    DemoClient demoClient() {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(DemoClient.class);
    }

    @Bean
    TimeClient timeClient() {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(TimeClient.class);
    }
}
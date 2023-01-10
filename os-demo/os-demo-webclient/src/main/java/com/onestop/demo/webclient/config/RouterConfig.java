package com.onestop.demo.webclient.config;

/**
 * @author Clark
 * @version 2023/1/5
 */

import com.onestop.demo.webclient.handler.BizHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 业务路由基本类
 */
@Configuration
public class RouterConfig {
  @Autowired
  private BizHandler bizHandler;

  @Bean
  public RouterFunction<ServerResponse> timerRouter() {
    return route(GET("/time"), bizHandler::getTime)
            .andRoute(GET("/times"), bizHandler::sendTimePerSec);
  }
}

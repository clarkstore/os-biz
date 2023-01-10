package com.onestop.demo.webclient.api;

import com.onestop.common.core.util.Res;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

/**
 * Springboot3.0 内置http客户端示例
 * 接口类型与参数要求与服务方一致
 * @author Clark
 * @version 2022/12/30
 */
@HttpExchange()
public interface TimeClient {

  @GetExchange("/time")
  Mono<Res> time();
  @GetExchange("/times")
  Mono<Res> times();
}

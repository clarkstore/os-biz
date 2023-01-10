package com.onestop.demo.webclient.api;

import com.onestop.common.core.util.Res;
import com.onestop.demo.webclient.dto.ReqDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

/**
 * Springboot3.0 内置http客户端示例
 * 接口类型与参数要求与服务方一致
 * @author Clark
 * @version 2022/12/30
 */
//@HttpExchange(url = "/demo", accept = "application/json", contentType = "application/json")
@HttpExchange(url = "/demo")
public interface DemoClient {
  @GetExchange("/get/{val}")
  Mono<Res> get(@PathVariable String val);

  @PostExchange("/post")
  Mono<Res> post(@RequestBody ReqDto dto);
//
//  @GetExchange("/webfluxGet/{val}")
//  Mono<Res> webfluxGet(@PathVariable String val);
//  @PostMapping(value = "/webfluxPost", consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//  Mono<Res> webfluxPost(@RequestBody ReqDto dto);
}

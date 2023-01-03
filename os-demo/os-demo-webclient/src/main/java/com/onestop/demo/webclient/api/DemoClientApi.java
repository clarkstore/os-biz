package com.onestop.demo.webclient.api;

import com.onestop.demo.webclient.dto.ReqDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * Springboot3.0 内置http客户端示例
 * 接口类型与参数要求与服务方一致
 * @author Clark
 * @version 2022/12/30
 */
@HttpExchange("/demo")
public interface DemoClientApi {
  @GetExchange("/get/{id}")
  ReqDto get(@PathVariable String id);

  @PostExchange("/post")
  ReqDto post(@RequestBody ReqDto dto);
}

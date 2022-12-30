package com.onestop.demo.webclient.api;

import com.onestop.demo.webclient.dto.ReqDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author Clark
 * @version 2022/12/30
 */
@HttpExchange("/web")
public interface WebClientApi {
  @GetExchange("/get/{id}")
  ReqDto get(@PathVariable String id);

  @PostExchange("/post")
  ReqDto post(@RequestBody ReqDto dto);
}

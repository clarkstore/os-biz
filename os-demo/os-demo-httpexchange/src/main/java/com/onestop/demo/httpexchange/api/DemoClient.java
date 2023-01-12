package com.onestop.demo.httpexchange.api;

import com.onestop.common.core.util.Res;
import com.onestop.demo.httpexchange.dto.ReqDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Springboot3.0 内置http客户端示例
 * 接口类型与参数要求与服务方一致，对应DemoApi相应接口
 *
 * @author Clark
 * @version 2023/01/12
 */
@HttpExchange(url = "/demo")
public interface DemoClient {
    /**
     * 同步接口异步调用改造
     *
     * @param val
     * @return
     */
    @GetExchange("/get/{val}")
    Mono<Res> get(@PathVariable String val);

    /**
     * 同步接口异步调用改造
     *
     * @return
     */
    @GetExchange("/getList")
    Mono<Res> getList();

    /**
     * 异步接口
     *
     * @return
     */
    @GetExchange("/getList4Flux")
    Flux<ReqDto> getList4Flux();

    /**
     * 同步接口异步调用改造
     *
     * @param dto
     * @return
     */
    @PostExchange("/post")
    Mono<Res> post(@RequestBody ReqDto dto);
}

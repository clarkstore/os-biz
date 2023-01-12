package com.onestop.demo.webflux.handler;

import cn.hutool.core.date.DateUtil;
import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * 业务处理类
 */
@Slf4j
@Component
public class BizHandler {
    public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
        log.debug("----------getTime-----------");
        return ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(Mono.just(DateUtil.now()), Res.class);
    }

    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        log.debug("----------sendTimePerSec-----------");
        return ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(
                Flux.interval(Duration.ofSeconds(1)).
                        map(item -> Res.ok(DateUtil.now())), Res.class);
    }
}


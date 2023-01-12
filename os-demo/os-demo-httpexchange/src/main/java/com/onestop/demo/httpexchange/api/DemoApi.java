package com.onestop.demo.httpexchange.api;

import cn.hutool.core.collection.CollUtil;
import com.onestop.common.core.util.Res;
import com.onestop.demo.httpexchange.dto.ReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * webclient demo用api
 * @author Clark
 * @version 2022-2-22
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoApi {
    private static final long SLEEP_TIME = 2000;
    @GetMapping("/get/{val}")
    public Res get(@PathVariable String val) throws InterruptedException {
        log.warn("================业务 get==================");
        log.warn("val=" + val);
        Thread.sleep(SLEEP_TIME);
        log.warn("================return SLEEP TIME:{}==================", SLEEP_TIME);
        return Res.ok(val);
    }
    @GetMapping("/getList")
    public Res getList() throws InterruptedException {
        log.warn("================业务 getList==================");
        ReqDto req1 = ReqDto.builder()
                .id("1")
                .name("张三").build();
        ReqDto req2 = ReqDto.builder()
                .id("2")
                .name("李四").build();
        List<ReqDto> list = CollUtil.newArrayList(req1, req2);
        Thread.sleep(SLEEP_TIME);
        log.warn("================return SLEEP TIME:{}==================", SLEEP_TIME);
        return Res.ok(list);
    }

    /**
     * 异步接口
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/getList4Flux")
    public Flux<ReqDto> getList4Flux() throws InterruptedException {
        log.warn("================业务 getList==================");
        ReqDto req1 = ReqDto.builder()
                .id("1")
                .name("张三").build();
        ReqDto req2 = ReqDto.builder()
                .id("2")
                .name("李四").build();

        Thread.sleep(SLEEP_TIME);
        log.warn("================return SLEEP TIME:{}==================", SLEEP_TIME);
        return Flux.just(req1, req2);
    }

    @PostMapping("/post")
    public Res post(@RequestBody ReqDto dto) throws InterruptedException {
        log.warn("================业务 post==================");
        log.warn("dto=" + dto.toString());
        Thread.sleep(SLEEP_TIME);
        log.warn("================return SLEEP TIME:{}==================", SLEEP_TIME);
        return Res.ok(dto);
    }
}

package com.onestop.demo.httpexchange.api;

import cn.hutool.core.collection.CollUtil;
import com.onestop.common.core.util.Res;
import com.onestop.demo.httpexchange.dto.ReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Springboot3.0 内置http客户端 Demo调用api
 * <p>示例方法的休眠为异步调用时测试效果</p>
 * @author Clark
 * @version 2022-2-22
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoApi {
    private static final long SLEEP_TIME = 2000;
    /**
     * @param val
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/get/{val}")
    public Res get(@PathVariable String val) throws InterruptedException {
        log.warn("================业务 get==================");
        log.warn("val=" + val);
        Thread.sleep(SLEEP_TIME);
        log.warn("================return SLEEP TIME:{}==================", SLEEP_TIME);
        return Res.ok(val);
    }

    /**
     *
     * @return
     * @throws InterruptedException
     */
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
     * 仅为测试返回异步集合结果，通常采用getList方式返回结果
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

    /**
     *
     * @param dto
     * @return
     * @throws InterruptedException
     */
    @PostMapping("/post")
    public Res post(@RequestBody ReqDto dto) throws InterruptedException {
        log.warn("================业务 post==================");
        log.warn("dto=" + dto.toString());
        Thread.sleep(SLEEP_TIME);
        log.warn("================return SLEEP TIME:{}==================", SLEEP_TIME);
        return Res.ok(dto);
    }
}

package com.onestop.demo.httpexchange.api;

import com.onestop.common.core.util.Res;
import com.onestop.demo.httpexchange.dto.ReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * webclient demo用api
 * @author Clark
 * @version 2022-2-22
 */
@Slf4j
@RestController
@RequestMapping("/rpc")
public class RpcApi {
    @Autowired
    private DemoClient demoClient;

    /**
     * 异步方式调用
     * 查看log顺序
     * @param val
     * @return
     */
    @GetMapping("/get/{val}")
    public Res get(@PathVariable String val) {
        log.error("================rpc get==================");
        //异步方式调用
        this.demoClient.get(val).subscribe(res -> {
            log.error("----------rpc subscribe---------");
            log.error(res.toString());
        });
        log.error("================rpc return==================");
        return Res.ok();
    }

    /**
     * 异步接口同步方式调用
     * 查看log顺序
     * @return
     */
    @GetMapping("/getList")
    public Res getList() {
        log.error("================rpc getList==================");
        //同步方式调用
        var res = this.demoClient.getList().block();
        log.error("================rpc return==================");
        return res;
    }

    /**
     * 调用返回集合方式
     * 仅为测试返回异步集合结果，通常采用getList方式返回结果
     * @return
     */
    @GetMapping("/getList4Flux")
    public Res getList4Flux() {
        log.error("================rpc getList4Flux==================");
        //同步方式调用
//        Flux<ReqDto> flux = this.demoClient.getList4Flux();
//        List<ReqDto> list = flux.collectList().block();
//        log.error(list.toString());
//        return Res.ok(list);
        //异步方式调用
        this.demoClient.getList4Flux().subscribe(data -> {
            log.error("----------rpc subscribe---------");
            log.error(data.toString());
        });
        log.error("================rpc return==================");
        return Res.ok();
    }

    /**
     *
     * @param dto
     * @return
     */
    @PostMapping("/post")
    public Res post(@RequestBody ReqDto dto) {
        log.error("================rpc post==================");
        log.error("dto=" + dto.toString());
        //同步方式调用
//        var res = this.demoClient.post(dto).block();
//        return res;
        //异步方式调用
        this.demoClient.post(dto).subscribe(res -> {
            log.error("----------rpc subscribe---------");
            log.error(res.toString());
        });
        log.error("================rpc return==================");
        return Res.ok();
    }
}

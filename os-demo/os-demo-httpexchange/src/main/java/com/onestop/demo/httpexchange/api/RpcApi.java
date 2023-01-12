package com.onestop.demo.httpexchange.api;

import com.onestop.common.core.util.Res;
import com.onestop.demo.httpexchange.dto.ReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/rpc")
public class RpcApi {
    @Autowired
    private DemoClient demoClient;

    /**
     *
     * @param val
     * @return
     */
    @GetMapping("/get/{val}")
    public Res get(@PathVariable String val) {
        log.error("================rpc get==================");
        this.demoClient.get(val).subscribe(res -> {
            log.error("----------rpc subscribe---------");
            log.error(res.toString());
        });
        log.error("================rpc return==================");
        return Res.ok();
    }

    @GetMapping("/getList")
    public Res getList() {
        log.error("================rpc getList==================");
        //同步方式调用
        var res = this.demoClient.getList().block();
        log.error("================rpc return==================");
        return res;
    }

    @GetMapping("/getList4Flux")
    public Res getList4Flux() {
        log.error("================rpc getList4Flux==================");
        //同步方式调用
        Flux<ReqDto> flux = this.demoClient.getList4Flux();
        List<ReqDto> list = flux.collectList().block();
        log.error(list.toString());
//        return res;
        //异步方式调用
//        this.demoClient.getList4Flux().subscribe(data -> {
//            log.error("----------rpc subscribe---------");
//            log.error(data.toString());
//        });
        log.error("================rpc return==================");
        return Res.ok(list);
    }

    @PostMapping("/post")
    public Res post(@RequestBody ReqDto dto) {
        log.error("================rpc post==================");
        log.error("dto=" + dto.toString());

        this.demoClient.post(dto).subscribe(res -> {
            log.error("----------rpc subscribe---------");
            log.error(res.toString());
        });
        log.error("================rpc return==================");
        return Res.ok();
    }
}

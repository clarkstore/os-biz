package com.onestop.demo.webclient.api;

import com.onestop.common.core.util.Res;
import com.onestop.demo.webclient.dto.ReqDto;
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

    @PostMapping("/post")
    public Res post(@RequestBody ReqDto dto) {
        log.warn("================rpc post==================");
        log.warn("dto=" + dto.toString());

        this.demoClient.post(dto).subscribe(res -> {
            log.error("----------rpc subscribe---------");
            log.error(res.toString());
        });
        log.warn("================rpc return==================");
        return Res.ok();
    }
}

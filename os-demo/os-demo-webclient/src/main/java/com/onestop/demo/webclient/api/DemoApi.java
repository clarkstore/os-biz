package com.onestop.demo.webclient.api;

import com.onestop.common.core.util.Res;
import com.onestop.demo.webclient.dto.ReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * webclient demo用api
 * @author Clark
 * @version 2022-2-22
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoApi {
    @GetMapping("/get/{val}")
    public Res get(@PathVariable String val) throws InterruptedException {
        log.warn("================业务 get==================");
        log.warn("val=" + val);
        Thread.sleep(3000);
        log.warn("================return==================");
        return Res.ok(val);
    }

    @PostMapping("/post")
    public Res post(@RequestBody ReqDto dto) throws InterruptedException {
        log.warn("================业务 post==================");
        log.warn("dto=" + dto.toString());
        Thread.sleep(3000);
        log.warn("================return==================");
        return Res.ok(dto);
    }
}

package com.onestop.demo.http.api;

import com.onestop.common.core.util.Res;
import com.onestop.demo.http.dto.ReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 服务限流demo
 * @author Clark
 * @version 2022-2-22
 */
@Slf4j
@RestController
@RequestMapping("/web")
public class WebApi {

    @GetMapping("/get/{id}")
    public Res get(@PathVariable String id) {
        log.warn("================get==================");
        return Res.ok("OK");
    }

    @PostMapping("/post")
    public Res post(@RequestBody ReqDto dto) {
        log.warn("================post==================");
        return Res.ok(dto.toString());
    }
}

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
@RequestMapping("/demo")
public class DemoApi {

    @GetMapping("/get/{id}")
    public Res get(@PathVariable String id) {
        log.warn("================get==================");
        log.warn("id=" + id);
        return Res.ok(id);
    }

    @PostMapping("/post")
    public Res post(@RequestBody ReqDto dto) {
        log.warn("================post==================");
        log.warn("dto=" + dto.toString());
        return Res.ok(dto.toString());
    }
}

package com.onestop.demo.log.api;

import com.onestop.demo.log.model.dto.ReqDto;
import com.onestop.common.core.util.Res;
import com.onestop.common.log.annotation.OsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 服务限流demo
 * @author Clark
 * @version 2022-2-22
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogApi {

    /**
     * 访问限流
     * @return
     */
    @OsLog("get方法")
    @GetMapping("/get/{id}")
    public Res get(@PathVariable String id) {
        log.warn("================get==================");
        return Res.ok("OK");
    }

    @OsLog
    @PostMapping("post")
    public Res post(@RequestBody ReqDto dto) {
        log.warn("================post==================");
        return Res.ok(dto.toString());
    }
}

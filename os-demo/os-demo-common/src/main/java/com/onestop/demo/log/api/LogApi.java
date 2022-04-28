package com.onestop.demo.log.api;

import cn.hutool.core.date.DateUtil;
import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注解日志demo
 * @author Clark
 * @version 2021-10-27
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogApi {

    @OsLog("业务接口日志")
    @GetMapping("/{id}")
    public Res get(@PathVariable String id) {
        log.warn("------注解日志demo 开始------");
        log.warn("------注解日志demo 结束------");
        return Res.ok(DateUtil.now());
    }
}

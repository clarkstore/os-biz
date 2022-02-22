package com.onestop.demo.http.api;

import cn.hutool.core.date.DateUtil;
import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Clark
 * @version 2021-10-27
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoApi {
    @GetMapping("getDate")
    public Res getDate() {
        log.warn("------进入被调用方法------");
//        throw new RuntimeException();
//        ThreadUtil.sleep(5, TimeUnit.SECONDS);
        return Res.ok(DateUtil.now());
    }
}

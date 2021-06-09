package com.onestop.nacos.discovery.api;

import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Clark
 * @version 2021/6/9
 */
@Slf4j
@RestController
@RequestMapping("provider/test")
public class TestApi {

    @GetMapping
    public Res test() {


        return Res.ok("生产者调用");
    }
}

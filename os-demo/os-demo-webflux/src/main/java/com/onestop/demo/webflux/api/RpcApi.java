package com.onestop.demo.webflux.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private TimeClient timeClient;

}

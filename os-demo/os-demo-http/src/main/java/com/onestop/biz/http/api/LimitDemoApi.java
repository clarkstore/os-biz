package com.onestop.biz.http.api;

import com.onestop.common.core.util.Res;
import com.onestop.common.http.annotation.OsAccessLimit;
import com.onestop.common.http.constant.OsLimitTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务限流demo
 * @author Clark
 * @version 2022-2-22
 */
@Slf4j
@RestController
@RequestMapping("/limit")
public class LimitDemoApi {

    /**
     * 访问限流
     * @return
     */
    @GetMapping
    // 在限定的limitSec时间内可以访问的次数limitCount，超过即限流.
    @OsAccessLimit(limitCount = 1, limitSec = 10, limitType = OsLimitTypeEnum.METHOD_NAME)
//    @OsAccessLimit(limitCount = 1, limitSec = 10, limitType = OsLimitTypeEnum.IP)
    // CUSTOMER的类型下，相同key的接口相当于共享限流设定
//    @OsAccessLimit(limitCount = 1, limitSec = 10, limitType = OsLimitTypeEnum.CUSTOMER, key = "test")
    public Res get() {
        log.warn("================Limit==================");
        return Res.ok("访问成功");
    }

    @GetMapping("test")
    @OsAccessLimit(limitCount = 1, limitSec = 10, limitType = OsLimitTypeEnum.CUSTOMER, key = "test")
    public Res test() {
        log.warn("================test==================");
        return Res.ok("访问成功");
    }
}

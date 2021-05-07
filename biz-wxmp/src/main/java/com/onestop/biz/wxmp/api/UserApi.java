package com.onestop.biz.wxmp.api;

import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Clark
 * @version 2021/4/26
 */
@Slf4j
@RestController
@RequestMapping("${os.wxmp.apiPath}/user")
public class UserApi extends BaseApi {
    @GetMapping("/")
    public Res index() {
        log.error("===========index============");
        return Res.ok();
    }
}

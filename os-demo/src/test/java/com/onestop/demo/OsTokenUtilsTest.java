package com.onestop.demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.jwt.JWTPayload;
import com.onestop.common.core.util.OsTokenUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Map;

/**
 * @author Clark
 * @version 2021/9/13
 */
@SpringBootTest(classes = OsDemoApplication.class)
public class OsTokenUtilsTest {
    @Autowired
    private OsTokenUtils utils;

    @Test
    public void token() {
        // 设置过期时间：秒
        Date date = DateUtil.offsetMinute(DateUtil.date(), 1);
        Map<String, Object> payload = MapUtil.newHashMap();
        payload.put(JWTPayload.EXPIRES_AT, date);
        String token = utils.sign(payload);
        boolean result = utils.verify(token);
        System.out.println("result= " + result);
    }
}
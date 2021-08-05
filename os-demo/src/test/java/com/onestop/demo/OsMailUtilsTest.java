package com.onestop.demo;

import cn.hutool.core.map.MapUtil;
import com.onestop.common.core.util.OsMailUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @author Clark
 * @version 2021/7/22
 */
@SpringBootTest(classes = OsDemoApplication.class)
public class OsMailUtilsTest {
    @Autowired
    private OsMailUtils osMailUtils;

    @Test
    public void sendMail() {
        Map<String, Object> map = MapUtil.newHashMap();
        map.put("content", "你好，这封是测试邮件");
        this.osMailUtils.sendMail("收件人地址", "E999", map);
    }
}
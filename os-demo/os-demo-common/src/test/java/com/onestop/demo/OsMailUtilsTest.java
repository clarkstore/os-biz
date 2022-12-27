package com.onestop.demo;

import cn.hutool.core.map.MapUtil;
import com.onestop.common.core.util.OsMailUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @author Clark
 * @version 2021/7/22
 */
@SpringBootTest(classes = OsDemoApplication.class)
public class OsMailUtilsTest {
    /**
     * 收件人
     */
    @Value("${os.mail.from}")
    private String toAddr;
    @Autowired
    private OsMailUtils utils;

    @Test
    public void sendMail() {
        Map<String, Object> map = MapUtil.newHashMap();
        map.put("content", "你好，这封是测试邮件");
        this.utils.sendMail(toAddr, "E999", map);
    }
}
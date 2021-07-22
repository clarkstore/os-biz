package com.onestop.common.core.util;

import cn.hutool.core.collection.CollUtil;
import com.onestop.biz.common.BizCommonApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @author Clark
 * @version 2021/7/22
 */
@SpringBootTest(classes = BizCommonApplication.class)
public class OsMailUtilsTest {
    @Autowired
    private OsMailUtils osMailUtils;

    @Test
    public void sendMail() {
        Map<String, Object> map = CollUtil.newHashMap();
        map.put("content", "你好，这封是测试邮件");
        this.osMailUtils.sendMail("收件人地址", "E999", map);
    }
}
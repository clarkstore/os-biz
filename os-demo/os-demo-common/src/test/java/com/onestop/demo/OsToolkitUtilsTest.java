package com.onestop.demo;

import cn.hutool.core.map.MapUtil;
import com.onestop.extra.toolkit.OsMailUtils;
import com.onestop.extra.toolkit.OsSeqUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @author Clark
 * @version 2021/7/22
 */
@SpringBootTest(classes = OsDemoApplication.class)
public class OsToolkitUtilsTest {
    /**
     * 收件人
     */
    private String toAddr;
    @Autowired(required = false)
    private OsMailUtils mailUtils;
    @Autowired(required = false)
    private OsSeqUtils seqUtils;

    @Test
    public void sendMail() {
        Map<String, Object> map = MapUtil.newHashMap();
        map.put("content", "你好，这封是测试邮件");
        this.mailUtils.sendMail(toAddr, "E999", map);
    }

    @Test
    public void getSeqNo() {
        String seqNo = this.seqUtils.getSeqNo();
        System.out.println("无业务标识: " + seqNo);
        seqNo = this.seqUtils.getSeqNo("AB");
        System.out.println("有业务标识: " + seqNo);
    }
}
package com.onestop.demo;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.onestop.ali.sms.util.OsSmsUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Clark
 * @version 2021/7/22
 */
@SpringBootTest(classes = OsDemoApplication.class)
public class OsSmsUtilsTest {
    @Autowired
    private OsSmsUtils utils;

    @Test
    public void sendSms() throws Exception {
        SendSmsRequest smsRequest = new SendSmsRequest();
        smsRequest.setPhoneNumbers("xxxx");
        smsRequest.setSignName("xxxx");
        smsRequest.setTemplateCode("SMS_222570015");
        smsRequest.setTemplateParam("{\"code\":\"4321\"}");
        utils.sendSms(smsRequest);
    }
}
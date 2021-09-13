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
    public void sendSms() {
        SendSmsRequest smsRequest = new SendSmsRequest();
        smsRequest.setPhoneNumbers("13190138656");
        smsRequest.setSignName("Blooming网");
        smsRequest.setTemplateCode("SMS_204240296");
        smsRequest.setTemplateParam("{\"code\":\"4321\"}");
        utils.sendSms(smsRequest);
    }
}
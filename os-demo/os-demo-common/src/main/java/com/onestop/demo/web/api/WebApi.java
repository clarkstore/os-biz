package com.onestop.demo.web.api;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.jwt.JWTPayload;
import com.onestop.common.core.util.Res;
import com.onestop.common.web.annotation.OsAuthTokenAnnotation;
import com.onestop.common.web.annotation.OsDesensitizationAnnotation;
import com.onestop.common.web.annotation.OsResAesAnnotation;
import com.onestop.common.web.constant.OsDesensitizationTypeEnum;
import com.onestop.common.web.util.OsTokenUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * Web模块demo
 * @author Clark
 * @version 2022-2-22
 */
@Slf4j
@RestController
@RequestMapping("/web")
public class WebApi {
    @Autowired(required = false)
    private OsTokenUtils osTokenUtils;

    /**
     * aes加密返回
     * @return
     */
    @GetMapping("aes")
    @OsResAesAnnotation
    public Res aes() {
        log.warn("================Aes==================");
        return Res.ok("访问成功");
    }

    /**
     * 验证token
     * @return
     */
    @GetMapping("authToken")
    @OsAuthTokenAnnotation
    public Res authToken() {
        log.warn("================authToken==================");
        return Res.ok("验证成功");
    }

    /**
     * 获取token(60秒有效)
     * @return
     */
    @GetMapping("getToken")
    public Res getToken() {
        // 设置过期时间：60秒(可不配置,默认值为7200秒)
        Date date = DateUtil.offsetSecond(DateUtil.date(), 60);
        Map<String, Object> payload = MapUtil.newHashMap();
        payload.put(JWTPayload.EXPIRES_AT, date);
        String token = osTokenUtils.sign(payload);
        log.warn("token= " + token);
        return Res.ok(token);
    }

    /**
     * 数据脱敏
     * @return
     */
    @GetMapping("getDesensitizationInfo")
    public Res getDesensitizationInfo() {
        return Res.ok(new DesensitizationDto());
    }

    @Getter
    @Setter
    public class DesensitizationDto {
        @OsDesensitizationAnnotation(type = OsDesensitizationTypeEnum.CUSTOMER, prefixNoMaskLen = 1, suffixNoMaskLen = 5)
        private String id = "1234567890";
        @OsDesensitizationAnnotation(type = OsDesensitizationTypeEnum.CHINESE_NAME)
        private String name = "张三三";
        @OsDesensitizationAnnotation(type = OsDesensitizationTypeEnum.ID_CARD)
        private String idcard = "210123200001011019";
        @OsDesensitizationAnnotation(type = OsDesensitizationTypeEnum.MOBILE_PHONE)
        private String phone = "13912345678";
        @OsDesensitizationAnnotation(type = OsDesensitizationTypeEnum.EMAIL)
        private String email = "abc@126.com";
    }
}

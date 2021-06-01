package com.onestop.biz.wxmp.api;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前端页面跳转控制器
 *
 * @author Clark
 * @version 2021/04/30
 */
@Slf4j
@Controller
@RequestMapping("${os.wxmp.apiPath}/goto")
public class GotoApi extends BaseApi {
    @Value("${os.wxmp.uiPath}")
    private String uiPath;
    /**
     * 取得用户信息
     */
    private static final String PATH_APPOINTMENT = "/appointment?openid={}&auth={}";
    /**
     * 取得用户信息
     */
    private static final String PATH_LIST = "/list?openid={}&auth={}";
    /**
     * 取得用户信息
     */
    private static final String PATH_USER_REGISTER = "/userRegister?openid={}&auth={}";

    /**
     * 获取openid，跳转身份验证页面
     *
     * @param code
     * @return String
     */
    @GetMapping("getAccessToken")
    public String getAccessToken(String code, String state) {
        String openid = super.osWxMpUtils.getOpenid(code);

        String bizPath = "";
        switch (state) {
            case "appointment":
                bizPath = PATH_APPOINTMENT;
                break;
            case "list":
                bizPath = PATH_LIST;
                break;
            default:
                bizPath = PATH_USER_REGISTER;
        }

        StringBuilder builder = new StringBuilder("redirect:")
                .append(this.uiPath)
                .append(StrUtil.format(bizPath, openid));
        return builder.toString();
    }
}
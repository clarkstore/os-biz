package com.onestop.biz.wxmp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.onestop.biz.wxmp.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Clark
 * @version 2021/4/26
 */
@Service
public class OuterService {
    /**
     * 取得用户信息
     */
    private static final String URL_GET_USERINFO = "https://www.baidu.com";
    /**
     * 注册
     */
    private static final String URL_POST_REGISTER = "https://www.baidu.com";
    /**
     * 开单
     */
    private static final String URL_POST_CREATE = "https://www.baidu.com";
    /**
     * 查询
     */
    private static final String URL_GET_LIST = "https://www.baidu.com";
    /**
     * 详细
     */
    private static final String URL_GET_DETAIL = "https://www.baidu.com";

    public UserDto getUserInfo(String openid) {
        Map<String, Object> paramMap = CollUtil.newHashMap();
        paramMap.put("openid", openid);

        String result = HttpUtil.get(URL_GET_USERINFO, paramMap);
        //TODO 转换
        UserDto dto = JSONUtil.toBean(result, UserDto.class);
        return dto;
    }

    public void register(String openid, String email) {
        //TODO 转换
        String jsonStr = JSONUtil.toJsonStr(Object.class);

        String result = HttpUtil.post(URL_POST_REGISTER, jsonStr);
    }
}

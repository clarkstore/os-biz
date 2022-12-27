package com.onestop.biz.wxmp.api;

import com.onestop.wx.mp.util.OsWxMpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 接口基类
 *
 * @author Clark
 * @date 2020-07-28
 */
public abstract class BaseApi {
    @Value("${os.service.uiFullPath}")
    protected String uiFullPath;
    @Autowired
    protected OsWxMpUtils osWxMpUtils;
}
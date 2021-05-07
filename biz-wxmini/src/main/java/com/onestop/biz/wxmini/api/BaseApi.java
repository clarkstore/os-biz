package com.onestop.biz.wxmini.api;

import com.onestop.biz.common.util.CommonUtils;
import com.onestop.common.azure.storage.util.OsAzureStorageUtils;
import com.onestop.wx.mini.util.OsWxMiniUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 接口基类
 *
 * @author Clark
 * @date 2020-07-28
 */
public abstract class BaseApi {
    @Value("${os.wxmini.uploadPath}")
    protected String uploadPath;
    @Autowired
    protected CommonUtils commonUtils;
    @Autowired
    protected OsAzureStorageUtils storageUtils;
    @Autowired
    protected OsWxMiniUtils miniUtils;
}
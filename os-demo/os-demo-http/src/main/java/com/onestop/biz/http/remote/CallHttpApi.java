package com.onestop.biz.http.remote;

import com.onestop.common.core.util.Res;

/**
 * 定义调用外部接口
 * @author Clark
 * @version 2022/2/15
 */
public interface CallHttpApi {
    /**
     * 同步调用
     * @return
     */
    Res getDate();
}

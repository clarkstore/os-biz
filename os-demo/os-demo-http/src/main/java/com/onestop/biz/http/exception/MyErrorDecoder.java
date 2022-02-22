package com.onestop.biz.http.exception;

import com.github.lianjiatech.retrofit.spring.boot.core.ErrorDecoder;
import com.onestop.common.core.exception.OsBizException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;

import java.io.IOException;

/**
 * 自定义api调用返回异常类型
 * 也可以全局异常类MyGlobalExceptionHandler中处理
 *
 * @author Clark
 * @version 2022/2/16
 */
@Slf4j
//@Component
public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public RuntimeException ioExceptionDecode(Request request, IOException cause) {
        log.error("-----------ioExceptionDecode-----------");
        return new OsBizException("服务不可用，请稍后再试");
    }

    @Override
    public RuntimeException exceptionDecode(Request request, Exception cause) {
        log.error("-----------exceptionDecode-----------");
        return new OsBizException("服务不可用，请稍后再试");
    }
}

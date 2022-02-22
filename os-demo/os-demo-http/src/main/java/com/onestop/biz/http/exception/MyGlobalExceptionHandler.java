package com.onestop.biz.http.exception;

import com.github.lianjiatech.retrofit.spring.boot.exception.RetrofitException;
import com.onestop.common.core.exception.OsBizException;
import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 * 根据@Order优先加载覆盖OsGlobalExceptionHandler
 * @author Clark
 * @date 2021/04/06
 */
@Slf4j
//@RestControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyGlobalExceptionHandler {
    /**
     * 自定义业务异常
     * @param e
     * @return Res 返回结果
     */
    @ExceptionHandler(value = {OsBizException.class})
    public Res bizExceptionHandle(OsBizException e) {
        log.error("=========GlobalExceptionHandler=========");
        log.error(e.getMsg());
        return Res.failed(e.getMsg());
    }

    /**
     * api调用异常
     * 也可以在自定义api调用返回异常类型MyErrorDecoder中处理
     * @param e RetrofitException
     * @return
     */
    @ExceptionHandler(value = {RetrofitException.class})
    public Res retrofitExceptionHandle(RetrofitException e) {
        log.error("=========RetrofitException=========");
        log.error(e.getMessage());
        return Res.failed(e.getMessage());
    }
}

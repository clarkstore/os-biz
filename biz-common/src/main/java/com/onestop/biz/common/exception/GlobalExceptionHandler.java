package com.onestop.biz.common.exception;

import com.onestop.common.core.exception.BizException;
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
public class GlobalExceptionHandler {
    /**
     *
     * @param e Biz Error
     * @return Res 返回结果
     */
    @ExceptionHandler(value = {BizException.class})
    public Res bizExceptionHandle(BizException e) {
        log.error("=========GlobalExceptionHandler=========");
        log.error(e.getMsg());
        return Res.failed(e.getMsg());
    }
}

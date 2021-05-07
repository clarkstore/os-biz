package com.onestop.biz.common.interceptor;

import com.onestop.common.core.interceptor.OsTokenInterceptor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义Token拦截器
 * 重写时追加自定义token逻辑
 * @author Clark
 * @version 2021-04-06
 */
@Slf4j
//@Configuration
//@Primary
public class MyTokenInterceptor extends OsTokenInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.debug("=========MyTokenInterceptor=========");
//        if (super.preHandle(request, response, handler)) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
//            //检查是否有AuthToken注释，有则认证
//            if (method.isAnnotationPresent(AuthToken.class)) {
//                AuthToken authToken = method.getAnnotation(AuthToken.class);
//                if (authToken.required()) {
//                    // TODO 重写时追加自定义token逻辑
////                if (StrUtil.isNotBlank(token) && StrUtil.isNotBlank(userid)) {
////                    // 验证token
////                    if (!TokenUtils.verify(token, userid)) {
////                        // 会话验证失败
////                        this.returnJson(response);
////                        return false;
////                    }
////                }
//                }
//            }
//        }

        return true;
    }
}

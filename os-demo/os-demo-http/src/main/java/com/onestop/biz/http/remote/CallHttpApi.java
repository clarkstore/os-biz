package com.onestop.biz.http.remote;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.degrade.Degrade;
import com.onestop.biz.http.remote.fallback.CallHttpApiFallback;
import com.onestop.common.core.util.Res;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 定义调用外部接口
 * @author Clark
 * @version 2022/2/15
 */
@RetrofitClient(baseUrl = "${os.service.apiBaseUrl}/demo", fallback = CallHttpApiFallback.class)
//可以通过自定义注解实现统一拦截器赋值，见retrofit-spring-boot-starter例子
//@OsHttpSign(accessKeyId = "${test.accessKeyId}", accessKeySecret = "${test.accessKeySecret}")
//默认策略情况下，每5s平均响应时间不得超过500ms，否则启用熔断降级
@Degrade(count = 500)
public interface CallHttpApi {
    /**
     * 同步调用
     * @return
     */
    @GET("getDate")
    Res getDate();

    /**
     * 异步调用
     * @return
     */
    @GET("getDate")
    Call<Res> callGetDate();
}

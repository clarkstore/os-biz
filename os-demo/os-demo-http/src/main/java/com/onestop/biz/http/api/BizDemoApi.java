package com.onestop.biz.http.api;

import com.onestop.biz.http.remote.CallHttpApi;
import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 业务API调用第三方服务demo
 * @author Clark
 * @version 2022-2-22
 */
@Slf4j
@RestController
@RequestMapping("/biz")
public class BizDemoApi {
    /**
     * 调用第三方服务封装API
     */
    @Autowired
    private CallHttpApi callHttpApi;

    /**
     * 当前服务对外接口：同步
     * @return
     */
    @GetMapping("/get")
    public Res get() {
        log.error("================get==================");
        return callHttpApi.getDate();
    }

    /**
     * 当前服务对外接口：异步
     * 一般场景不会采用
     * @return
     */
    @GetMapping("/call")
    public Res call() {
        log.info("================call start==================");
        callHttpApi.callGetDate().enqueue(new Callback<Res>() {
            @Override
            public void onResponse(Call<Res> call, Response<Res> response) {
                if(response.isSuccessful()){
                    log.warn("================call 成功：对数据的处理操作==================");
                    //对数据的处理操作
                }else{
                    //请求出现错误例如：404 或者 500
                    log.error("================call 失败：请求出现错误例如：404 或者 500==================");
                }
            }

            @Override
            public void onFailure(Call<Res> call, Throwable throwable) {
                log.error("================call 失败==================");
            }
        });
        log.info("================call end==================");
        return Res.ok("ok");
    }
}

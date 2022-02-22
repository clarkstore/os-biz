package com.onestop.biz.http.remote.fallback;

import com.onestop.biz.http.remote.CallHttpApi;
import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Call;

/**
 * Api调用降级处理
 * @author Clark
 * @version 2022/2/15
 */
@Slf4j
@Component
public class CallHttpApiFallback implements CallHttpApi {
    @Override
    public Res getDate() {
        log.error("=========BizHttpApiFallback get===========");
        log.error("=========降级处理==========");
        return null;
    }
    @Override
    public Call<Res> callGetDate() {
        log.error("=========BizHttpApiFallback get===========");
        log.error("=========降级处理==========");
        return null;
    }
}

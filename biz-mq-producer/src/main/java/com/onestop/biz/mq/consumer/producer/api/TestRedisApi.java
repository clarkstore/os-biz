package com.onestop.biz.mq.consumer.producer.api;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.onestop.common.core.util.Res;
import com.onestop.starter.common.redis.util.OsRedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 工单接口
 *
 * @author Clark
 * @version 2021-04-01
 */
@Slf4j
@RestController
@RequestMapping("test/redis")
public class TestRedisApi {
    private static final String GOODS_KEY = "goods_key";
    private static int GOODS_VALUE = 50;

    @Autowired
    private OsRedisUtils osRedisUtils;

    @PostConstruct
    public void init() {
        this.osRedisUtils.set(GOODS_KEY, GOODS_VALUE);
    }

    List<String> list = CollUtil.newArrayList();

    @GetMapping
    public Res test() {
        int num = (int) this.osRedisUtils.get(GOODS_KEY);
        log.error("当前库存= " + num + " ------ size= " + list.size());
        if (num == 0) {
            return Res.failed("秒杀活动结束");
        }
        String lockKey = IdUtil.simpleUUID();
//        if (this.osRedisUtils.tryLock(lockKey)) {
        int stock = (int) this.osRedisUtils.decr(GOODS_KEY);
        log.error("扣除后库存：" + stock);
        if (stock < 0) {
            return Res.failed("秒杀活动结束");
        }
        list.add(lockKey);
//            this.osRedisUtils.unlock(lockKey);
//        }

        return Res.ok("秒杀成功");
    }
}

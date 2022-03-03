package com.onestop.biz.mq.consumer.producer.api;

import com.onestop.biz.common.constant.MqQueueConsts;
import com.onestop.common.core.util.Res;
import com.onestop.common.log.model.entity.BizLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工单接口
 *
 * @author Clark
 * @version 2021-04-01
 */
@Slf4j
@RestController
@RequestMapping("test/mq")
public class TestApi {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public Res test() {
        for (int i = 0; i < 1; i++) {
            BizLog bizLog = BizLog.builder()
                    .id("id-" + i)
                    .name("name-" + i).build();
            rabbitTemplate.convertAndSend(MqQueueConsts.EXCHANGE_TKT_CREATE,"", bizLog);
            rabbitTemplate.convertAndSend(MqQueueConsts.QUEUE_BIZLOG, bizLog);
            log.warn("==========test QUEUE=========");
        }
        return Res.ok();
    }

    @GetMapping("ex")
    public Res exchange() {
        for (int i = 0; i < 3; i++) {
            BizLog bizLog = BizLog.builder()
                    .id("id-" + i)
                    .name("name-" + i).build();
            rabbitTemplate.convertAndSend(MqQueueConsts.EXCHANGE_TKT_CREATE,"", bizLog);
            log.warn("==========test EXCHANGE=========");
        }
        return Res.ok();
    }
}

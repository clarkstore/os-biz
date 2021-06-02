package com.onestop.biz.mq.consumer.listener;

import com.onestop.biz.common.constant.MqQueueConsts;
import com.onestop.biz.common.model.entity.BizLog;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 测试扩展监听
 *
 * @author Clark
 * @version 2021/05/21
 */
@Slf4j
@Component
public class MsgListener {
    /**
     * 测试扩展队列
     */
    @RabbitListener(queues = MqQueueConsts.QUEUE_MSG2LOG)
    public void queueMsg2Log(BizLog bizLog, Channel channel, Message message) throws IOException {
        try {
            log.error("============queueMsg2Log==============");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
//        this.bizLogService.insert(bizLog);
    }
}

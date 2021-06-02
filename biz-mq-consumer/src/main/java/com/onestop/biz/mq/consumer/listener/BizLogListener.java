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
 * 日志保存监听
 *
 * @author Clark
 * @version 2021/05/21
 */
@Slf4j
@Component
public class BizLogListener {
    private int num = 0;
    /**
     * 保存日志内容
     */
    @RabbitListener(queues = MqQueueConsts.QUEUE_BIZLOG)
    public void saveBizLog(BizLog bizLog, Channel channel, Message message) throws IOException {
        try {
            log.error("============saveBizLog==============");
            ++num;
            if (num >= 3) {
                log.error("============bizLog= " + bizLog.toString());
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            log.error("============basicNack= " + num);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
//        this.bizLogService.insert(bizLog);
    }

    /**
     * 保存日志内容
     */
    @RabbitListener(queues = MqQueueConsts.QUEUE_TKT_CREATE)
    public void tktCreate(BizLog bizLog, Channel channel, Message message) throws IOException {
        try {
            log.error("============tktCreate==============");
//            log.error("============bizLog= " + bizLog);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
//        this.bizLogService.insert(bizLog);
    }
}

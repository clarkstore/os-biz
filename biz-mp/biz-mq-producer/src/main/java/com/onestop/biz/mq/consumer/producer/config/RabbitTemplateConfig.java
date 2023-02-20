/*
 *
 *  * Copyright (c) 2021 OneStop Authors. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.onestop.biz.mq.consumer.producer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 消息列队配置类
 *
 * @author Clark
 * @version 2021/5/17
 */
@Slf4j
@Component
public class RabbitTemplateConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);            //指定 ConfirmCallback
        rabbitTemplate.setReturnsCallback(this);             //指定 ReturnCallback
    }

    /**
     * 发送者确认监听
     *
     * @return RabbitTemplate.ConfirmCallback
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
//                    System.out.println("confirm 消息发送确认成功...消息ID为：" + correlationData.getId());
            log.error("confirm 消息发送确认成功...");
        } else {
            log.error("confirm 消息发送确认失败...消息ID为：" + correlationData.getId() + " 失败原因: " + cause);
        }
    }

    /**
     * 路由失败通知
     *
     * @return RabbitTemplate.ReturnsCallback
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.error("message: " + new String(returnedMessage.getMessage().getBody()));
        log.error("replyCode: " + returnedMessage.getReplyCode());
        log.error("replyText：" + returnedMessage.getReplyText());
        log.error("exchange : " + returnedMessage.getExchange());
        log.error("routing : " + returnedMessage.getRoutingKey());
    }
}
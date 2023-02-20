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

package com.onestop.biz.mq.consumer.config;

import com.onestop.biz.common.constant.MqQueueConsts;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息列队配置类
 *
 * @author Clark
 * @version 2021/5/17
 */
@Configuration
public class ConsumerRabbitConfig {
    /**
     * 日志保存队列
     *
     * @return
     */
    @Bean
    public Queue queueBizLog() {
        return new Queue(MqQueueConsts.QUEUE_BIZLOG);
    }

    /**
     * 工单创建同步队列
     *
     * @return
     */
    @Bean
    public Queue queueTktCreate() {
        return new Queue(MqQueueConsts.QUEUE_TKT_CREATE);
    }

    /**
     * 交换机 声明为FanoutExchange类型
     */
    @Bean
    public FanoutExchange tktCreateExchange() {
        return new FanoutExchange(MqQueueConsts.EXCHANGE_TKT_CREATE);
    }

    @Bean
    public Binding bindingFanoutExchangeA() {
        return BindingBuilder.bind(this.queueBizLog()).to(this.tktCreateExchange());
    }

    @Bean
    public Binding bindingFanoutExchangeB() {
        return BindingBuilder.bind(this.queueTktCreate()).to(this.tktCreateExchange());
    }
}
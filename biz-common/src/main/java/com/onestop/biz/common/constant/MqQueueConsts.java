package com.onestop.biz.common.constant;

/**
 * MQ 消息队列
 * @author Clark
 * @version 2021/05/18
 */
public interface MqQueueConsts {
    /**
     * 日志保存 rabbit队列名称
     */
    String QUEUE_BIZLOG = "queueBizLog";
    /**
     * 工单创建同步
     */
    String QUEUE_TKT_CREATE = "queueTktCreate";
    /**
     * 测试扩展队列名称
     */
    String QUEUE_MSG2LOG = "queueMsg2Log";

    String EXCHANGE_TKT_CREATE = "exchange_tkt_create";
}

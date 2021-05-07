package com.onestop.biz.wxmp.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author Clark
 * @version 2021/5/6
 */
@Getter
@Setter
@ToString
public class ApiRes implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 返回标记：成功标记=0，失败标记=1
     */
    private String status;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据
     */
    private String data;

    public boolean isOk() {
        return StatusCode.SUCCESS.equals(this.status);
    }

    /**
     * 消息常量类
     * code：0 / 1将不返回消息
     * 提示消息：1XX
     * 错误消息：2XX
     */
    public static class StatusCode {
        /**
         * 成功标记：0
         */
        public static final String SUCCESS = "0";
    }
}
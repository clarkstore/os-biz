package com.onestop.biz.common.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 微信应答消息配置
 * </p>
 *
 * @author Clark
 * @date 2020-01-15
 */
@Data
//@TableName("wx_res_msg")
public class WxResMsg extends Model<WxResMsg> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private String id;

    /**
     * 消息编号
     */
    @TableField("code")
    private Integer code;

    /**
     * 消息内容
     */
    @TableField("msg")
    private String msg;

    /**
     * 备注 预留多语言使用
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 删除标记
     */
    @TableField("del_flag")
    @TableLogic
    private String delFlag;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

package com.onestop.biz.common.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.onestop.biz.common.constant.BizConsts;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 接口日志信息类
 *
 * @author Clark
 * @version 2020/09/15
 */
@Builder
@Data
//@TableName("biz_log")
public class BizLog extends Model<BizLog> {
    @Tolerate
    public BizLog() {
    }
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 接口名称
     */
    private String name;
    /**
     * 请求密文
     */
    @TableField(value = "req_param")
    private String reqParam;
    /**
     * 请求明文
     */
    @TableField(value = "req_content")
    private String reqContent;
    /**
     * 应答明文
     */
    @TableField(value = "res_content")
    private String resContent;
    /**
     * 应答密文
     */
    @TableField(value = "res_param")
    private String resParam;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 接口描述
     */
    private String description;
    /**
     * 业务交互状态（1代表交互成功，0代表交互失败）
     */
    @Builder.Default
    private String status = BizConsts.BizLogConsts.STATUS_SUCCESS;
    /**
     * 日志类型（1代表自动调用接口，2代表手动调用接口）
     */
    @Builder.Default
    private String type = BizConsts.BizLogConsts.TYPE_AUTO;

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

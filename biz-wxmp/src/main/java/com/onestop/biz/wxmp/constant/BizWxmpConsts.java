package com.onestop.biz.wxmp.constant;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

import java.util.List;

/**
 * 业务常量类
 *
 * @author Clark
 * @version 2021-09-28
 */
public class BizWxmpConsts {
    /**
     * 微信订阅消息常量类
     */
    public interface WxSubscribeMsgConsts {
        /**
         * 充值成功
         */
        String MSG_ID_PAY_NOTIFY = "payNotify";

        /**
         * 取得支付成功数据
         * @param outTradeNo
         * @param totalFee
         * @param timeEnd
         * @return
         */
        static List<String> getDataByPayNotify(String outTradeNo, int totalFee, String timeEnd) {
            // 格式化时间
            StringBuilder builder = new StringBuilder(16);
            builder.append(timeEnd.substring(0,4)).append(StrUtil.DASHED);
            builder.append(timeEnd.substring(4,6)).append(StrUtil.DASHED);
            builder.append(timeEnd.substring(6,8)).append(StrUtil.SPACE);
            builder.append(timeEnd.substring(8,10)).append(StrUtil.COLON);
            builder.append(timeEnd.substring(10,12));

            List<String> list = CollUtil.newArrayList();
            // 订单号
            list.add(outTradeNo);
            // 充值金额
            list.add(NumberUtil.decimalFormat(",##0.00", totalFee/100d) + "元");
            // 充值时间
            list.add(builder.toString());
            // 备注
            list.add("会员缴费");
            return list;
        }
    }
}

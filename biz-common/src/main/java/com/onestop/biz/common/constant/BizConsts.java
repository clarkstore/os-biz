package com.onestop.biz.common.constant;

/**
 * 业务常量类
 *
 * @author Clark
 * @version 2020-09-15
 */
public class BizConsts {
    /**
     * DB常量
     */
    public static class DBConsts {
        /**
         * 正常
         */
        public static final int NORMAL = 0;
        /**
         * 删除
         */
        public static final int DELETED = 1;
    }
    /**
     * 接口日志常量
     */
    public static class BizLogConsts {
        /**
         * 处理成功
         */
        public static final String STATUS_SUCCESS = "1";
        /**
         * 处理失败
         */
        public static final String STATUS_FAIL = "0";
        /**
         * 业务类型1代表自动调用接口 类型
         */
        public static final String TYPE_AUTO = "1";
        /**
         * 业务类型2代表手动调用接口 类型
         */
        public static final String TYPE_MANUAL = "2";
    }

    public static class Wxmini {
        /**
         * 二维码扩展名
         */
        public static final String QRCODE_IMG_EXTNAME = ".jpg";
        /**
         * 原始图
         */
        public static final String QRCODE_IMG_PARENT = "parent" + QRCODE_IMG_EXTNAME;
        /**
         * 微信小程序二维码
         */
        public static final String QRCODE_IMG_WXQRCODE = "wxQrcode" + QRCODE_IMG_EXTNAME;
        /**
         * 打印业务二维码
         */
        public static final String QRCODE_IMG_BIZQRCODE = "bizQrcode" + QRCODE_IMG_EXTNAME;
    }
}

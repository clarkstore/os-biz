package com.onestop.biz.wxmini.constant;

/**
 * 业务常量类
 *
 * @author Clark
 * @version 2020-09-15
 */
public class BizWxminiConsts {
    public static class WxminiConsts {
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

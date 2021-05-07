package com.onestop.biz.common.util;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * 公共工具类
 */
@Component
public class CommonUtils {
    /**
     * 随机数长度
     */
    private static final int RANDOM_LENGTH = 6;

    /**
     * 生成数字验证码
     * @return
     */
    public String getVCode() {
        return RandomUtil.randomNumbers(RANDOM_LENGTH);
    }

    /**
     * 生成6位随机数文件名
     * @return
     */
    public String getFileName() {
        return RandomUtil.randomString(RANDOM_LENGTH);
    }

    public void setText2Image() {
        ImgUtil.pressText(//
                FileUtil.file("e:/parent.jpg"), //
                FileUtil.file("e:/result.jpg"), //
                "版权所有", Color.BLACK, //文字
                new Font("黑体", Font.BOLD, 100), //字体
                -100, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                -100, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
        );
    }

    public void setImage2Image() {
        ImgUtil.pressImage(
                FileUtil.file("e:/result.jpg"),
                FileUtil.file("e:/result2.jpg"),
                ImgUtil.read(FileUtil.file("e:/payQRCode2.png")), //水印图片
                100, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                100, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                1.0f
        );
    }

    public static void main(String[] args) {
        CommonUtils utils = new CommonUtils();
        utils.setText2Image();
        utils.setImage2Image();
    }
}

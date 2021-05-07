package com.onestop.biz.wxmini.api;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.microsoft.azure.storage.StorageException;
import com.onestop.biz.common.constant.BizConsts;
import com.onestop.common.core.annotation.AuthToken;
import com.onestop.common.core.util.OsTokenUtils;
import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.StringJoiner;

/**
 * 微信小程序二维码接口
 *
 * @author Clark
 * @version 2021-04-01
 */
@Slf4j
@RestController
@RequestMapping("wxmini/api/qrcode")
public class QrcodeApi extends BaseApi {
    @Autowired
    private OsTokenUtils tokenUtils;

    @GetMapping("/del")
    @AuthToken
    public Res del() {
        try {
            super.storageUtils.getContainer().deleteIfExists();
        } catch (StorageException e) {
            e.printStackTrace();
        }
        log.error("===========del============");
        return Res.ok();
    }

    @GetMapping("/getToken")
    public Res getToken() {
        String token = this.tokenUtils.sign();
        log.error("token:" + token);
        return Res.ok(token);
    }

    /**
     * @param scene
     * @return
     */
    @GetMapping("/create")
    public Res create(String scene) {
        try {
            //TODO 解析 sceno，拆分SN和自定义No
            File wxQrcodeFile = this.createWxaCodeUnlimit(scene);
            File bizQrcode = this.createBizQrcode(scene, wxQrcodeFile);
            //生成目录全路径文件名
            String bizQrcodePath = this.getBlobFullName(bizQrcode.getName());
            this.storageUtils.upload(bizQrcodePath, new FileInputStream(bizQrcode));
            return Res.ok(bizQrcodePath);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return Res.failed(e.getError().getErrorMsg());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Res.failed(e.getMessage());
        }
    }

    /**
     * 生成小程序二维码
     *
     * @param scene
     * @return
     * @throws WxErrorException
     */
    private File createWxaCodeUnlimit(String scene) throws WxErrorException {
        try {
            return super.miniUtils.createWxaCodeUnlimit(scene, null, uploadPath);
        } catch (WxErrorException e) {
            log.error("---------------createWxaCodeUnlimit----------------");
            log.error("scene : " + scene);
            log.error(e.getError().toString());
            throw e;
        }
    }

    /**
     * 生成打印二维码
     *
     * @param no           业务号
     * @param wxQrcodeFile
     */
    private File createBizQrcode(String no, File wxQrcodeFile) {
        File parent = FileUtil.file(String.format("%s%s", uploadPath, BizConsts.Wxmini.QRCODE_IMG_PARENT));
        File textFile = FileUtil.file(String.format("%s%s%s", uploadPath, no, BizConsts.Wxmini.QRCODE_IMG_EXTNAME));
        // 追加文字
        ImgUtil.pressText(parent, textFile,
                "No:" + no, Color.WHITE,
                new Font("黑体", Font.BOLD, 48),
                100, -100, 1f);
        // 图片转换与压缩
        File wxQrcode = new File(String.format("%s%s%s", uploadPath, no, BizConsts.Wxmini.QRCODE_IMG_WXQRCODE));
        ImgUtil.convert(wxQrcodeFile, wxQrcode);
        ImgUtil.scale(wxQrcode, wxQrcode, 0.5f);
        // 业务二维码打印用
        File bizQrcode = FileUtil.file(String.format("%s%s%s", uploadPath, no, BizConsts.Wxmini.QRCODE_IMG_BIZQRCODE));
        ImgUtil.pressImage(textFile, bizQrcode,
                ImgUtil.read(FileUtil.file(wxQrcode)),
                100, 100, 1f);
        return bizQrcode;
    }

    /**
     * 生成目录全路径文件名
     *
     * @return
     */
    private String getBlobFullName(String fileName) {
        Snowflake sf = IdUtil.getSnowflake(1, 1);
        StringJoiner sj = new StringJoiner(StrUtil.SLASH);
        sj.add(DateUtil.format(DateUtil.date(), DatePattern.SIMPLE_MONTH_PATTERN))
                .add(sf.nextIdStr() + StrUtil.DOT + FileNameUtil.extName(fileName));
        return sj.toString();
    }
}

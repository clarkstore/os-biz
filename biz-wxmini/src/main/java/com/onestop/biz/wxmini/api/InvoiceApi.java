package com.onestop.biz.wxmini.api;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.onestop.common.core.exception.BizException;
import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 发票识别控制器
 *
 * @author Clark
 * @version 2020-08-28
 */
@Slf4j
@RestController
@RequestMapping("wxmini/api/invoice")
public class InvoiceApi extends BaseApi {
    /**
     * 普通发票上传
     *
     * @param request
     * @param file
     * @return
     */
    @PostMapping(value = "/normal")
    public Res normal(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            String openid = request.getParameter("openid");
            String invoiceStr = request.getParameter("invoice");
            String saveFilePath = this.saveFile(openid, invoiceStr, file);

        } catch (BizException e) {
            log.error(e.getMsg());
            return Res.failed(e.getMsg());
        }

        return Res.ok();
    }

    /**
     * 保存上传图片
     * @param openid
     * @param invoiceStr
     * @param file
     * @return
     */
    private String saveFile(String openid, String invoiceStr, MultipartFile file) {
        try {
            if (StrUtil.isBlank(openid)) {
                throw new BizException(1, "参数异常，请关闭后重新加载小程序！");
            }
            if (StrUtil.isBlank(invoiceStr)) {
                throw new BizException(1, "发票参数异常！");
            }
            if (file.isEmpty()) {
                throw new BizException(1, "文件不能为空！");
            }

            // 生成图片路径
            String imgPath = this.getImagePath(openid);
            // 原文件名称
            String originalFilename = file.getOriginalFilename();
            // 文件后缀
            String type = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            // 新文件名称
            String newFileName = super.commonUtils.getFileName() + type;
            // 目标文件夹
            String filePath = uploadPath + imgPath;
            // 保存路径
            String saveFilePath = imgPath + newFileName;
            // 文件全名
            String fullFileName = filePath + newFileName;
            // 判断文件夹是否存在，不存在则创建
            File targetFolder = new File(filePath);
            if (!FileUtil.isDirectory(targetFolder)) {
                FileUtil.mkdir(targetFolder);
            }
            // 保存文件
            file.transferTo(new File(fullFileName));
            return saveFilePath;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException(1, "图片上传异常，请稍后再试！");
        }
    }

    /**
     * 取得文件存储路径
     *
     * @param userId
     * @return
     */
    private String getImagePath(String userId) {
        //获得年的部分
        int year = DateUtil.thisYear();
        //获得月份，从0开始计数
        int month = DateUtil.thisMonth() + 1;
        //获得日期的部分
        int day = DateUtil.thisDayOfMonth();

        StringBuilder builder = new StringBuilder(16);
        builder.append(StrUtil.SLASH);
        builder.append(year).append(StrUtil.SLASH);
        builder.append(month).append(StrUtil.SLASH);
        builder.append(day).append(StrUtil.SLASH);
        builder.append(userId).append(StrUtil.SLASH);
        return builder.toString();
    }
}
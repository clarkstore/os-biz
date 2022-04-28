package com.onestop.biz.wxmini.api;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.onestop.ali.oss.util.OsOssUtils;
import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Clark
 * @version 2022-04-28
 */
@Slf4j
@RestController
@RequestMapping("${os.service.apiPath}/common")
public class CommonApi {
    private static final String OSS_PATH = "biz/";
    @Autowired
    private OsOssUtils osOssUtils;

    /**
     * 文件上传
     *
     * @api {GET} /app/api/common/upload 文件上传
     * @apiVersion 1.0.0
     * @apiGroup Common
     * @apiName upload
     * @apiParam (请求参数) {Object} file
     * @apiParamExample 请求参数示例
     * MultipartFile file
     * @apiSuccess (响应结果) {Number} code
     * @apiSuccess (响应结果) {String} msg
     * @apiSuccess (响应结果) {Object} data
     * @apiSuccessExample 响应结果示例
     * {"msg":"","code":0,"data":“生成文件路径”}
     */
    @PostMapping("/upload")
    public Res upload(@RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            // 生成文件路径
            String fullFileName = this.getFilePath(file.getOriginalFilename());
            this.osOssUtils.upload(OSS_PATH + fullFileName, file.getInputStream());
            return Res.ok(fullFileName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return Res.failed("上传失败请稍后再试");
        }
    }

    /**
     * 取得文件存储路径
     * @param fileName yyyyMMdd/fileName
     * @return 文件存储路径
     */
    private String getFilePath(String fileName) {
        StringBuilder builder = new StringBuilder(16);
        builder.append(DateUtil.format(DateUtil.date(), DatePattern.PURE_DATE_PATTERN)).append(StrUtil.SLASH);
        builder.append(fileName);
        return builder.toString();
    }
}

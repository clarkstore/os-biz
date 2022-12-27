package com.onestop.biz.wxmini.api;

import com.onestop.common.core.util.Res;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * 微信小程序二维码接口
 *
 * @author Clark
 * @version 2021-04-01
 */
@Slf4j
@RestController
@RequestMapping("${os.service.apiPath}/qrcode")
public class QrcodeApi extends BaseApi {
    /**
     * @param scene
     * @return
     */
    @GetMapping("/create")
    public Res create(String scene) {
        //TODO 解析 sceno，拆分SN和自定义No
        File wxQrcodeFile = this.createWxaCodeUnlimit(scene);
        return Res.ok(wxQrcodeFile);
    }

    /**
     * 生成小程序二维码
     *
     * @param scene
     * @return
     * @throws WxErrorException
     */
    private File createWxaCodeUnlimit(String scene) {
        String page = null;
        return super.miniUtils.createWxaCodeUnlimit(scene, page, uploadPath);
    }
}

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
@RequestMapping("wxmini/api/qrcode")
public class QrcodeApi extends BaseApi {
    /**
     * @param scene
     * @return
     */
    @GetMapping("/create")
    public Res create(String scene) {
        try {
            //TODO 解析 sceno，拆分SN和自定义No
            File wxQrcodeFile = this.createWxaCodeUnlimit(scene);
            return Res.ok(wxQrcodeFile);
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
        String page = null;

        try {
            return super.miniUtils.createWxaCodeUnlimit(scene, page, uploadPath);
        } catch (WxErrorException e) {
            log.error("---------------createWxaCodeUnlimit----------------");
            log.error("scene : " + scene);
            log.error(e.getError().toString());
            throw e;
        }
    }
}

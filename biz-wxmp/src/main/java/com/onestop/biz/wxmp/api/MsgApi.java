/*
 * Copyright (c) 2021 OneStop Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.onestop.biz.wxmp.api;

import com.onestop.biz.wxmp.constant.BizWxmpConsts;
import com.onestop.common.core.util.Res;
import com.onestop.wx.mp.model.dto.SubscribeReqDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author Clark
 * @version 2022-11-08
 */
@RestController
@RequestMapping("${os.service.apiPath}/msg")
public class MsgApi extends BaseApi {

    /**
     * 发送订阅消息
     * @param openid
     * @return
     */
    @GetMapping("/sendMsg/{openid}")
    public Res sendMsg(@PathVariable String openid) {
        List<String> list = BizWxmpConsts.WxSubscribeMsgConsts.getDataByPayNotify("1234567890", 111, "20990101010101");
        SubscribeReqDto subscribeReqDto = SubscribeReqDto.builder()
                .msgId(BizWxmpConsts.WxSubscribeMsgConsts.MSG_ID_PAY_NOTIFY)
                .openid(openid)
                .valueList(list).build();
        this.osWxMpUtils.sendSubscribeMsg(subscribeReqDto);
        return Res.ok();
    }
}
package com.onestop.biz.wxmp.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * 用户DTO
 * @author Clark
 * @version 2021/4/26
 */
@Builder
@Getter
@Setter
@ToString
public class UserDto {
    @Tolerate
    public UserDto() {}

    private String openid;
}


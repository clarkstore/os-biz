package com.onestop.demo.log.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * ReqDTO
 * @author Clark
 * @version 2021/12/28
 */
@Builder
@Getter
@Setter
@ToString
public class ReqDto {
    @Tolerate
    public ReqDto() {
    }

    private String id;
    private String name;
}

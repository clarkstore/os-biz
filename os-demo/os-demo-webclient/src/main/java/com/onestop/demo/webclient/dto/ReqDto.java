package com.onestop.demo.webclient.dto;

import lombok.Builder;

/**
 * ReqDto
 * @param id
 * @param name
 */
@Builder
public record ReqDto (String id, String name) {
}

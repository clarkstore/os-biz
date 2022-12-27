/*
 *
 *  * Copyright (c) 2021 os-parent Authors. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.onestop.demo.config;

import com.onestop.common.web.config.OsResponseBodyAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 实现统一处理controller返回
 *
 * @author Clark
 * @version 2022-12-27
 */
@RestControllerAdvice("com.onestop")
public class MyResponseBodyAdvice extends OsResponseBodyAdvice {
}
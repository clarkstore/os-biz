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

package com.onestop.biz.task.service.impl;

import com.onestop.common.task.service.IOsTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 定时任务服务实现类Demo
 *
 * @author Clark
 * @version 2021-04-08
 */
@Slf4j
@Service
public class TaskServiceImpl implements IOsTaskService {
    @Override
    public String getTaskNo() {
        return "ostask1";
    }

    @Override
    public void run() {
        log.debug("--------------业务实现---------------");
    }
}

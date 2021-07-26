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

package com.onestop.biz.task.api;

import com.onestop.biz.task.service.impl.TaskServiceImpl;
import com.onestop.common.core.util.Res;
import com.onestop.common.task.util.OsTaskSchedulerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定时任务demo接口
 * 如需扩展：业务模块中自行实现
 *
 * @author Clark
 * @version 2021-07-26
 */
@Slf4j
@RestController
@RequestMapping("task/api/demo")
public class TaskApi {
    @Autowired
    private OsTaskSchedulerUtils schedulerUtils;

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping("/reset")
    public Res reset(String taskNo, String cron) {
        if (taskService.getTaskNo().equals(taskNo)) {
            schedulerUtils.resetTask(taskService.getTaskNo(), taskService, cron);
            log.debug("定时任务重置：taskNo={0}, cron={1}", taskNo, cron);
        }
        return Res.ok("定时任务重置完成");
    }

    @GetMapping("/cancel")
    public Res cancel(String taskNo) {
        if (taskService.getTaskNo().equals(taskNo)) {
            schedulerUtils.cancelTask(taskService.getTaskNo());
            log.debug("定时任务取消：taskNo={0}", taskNo);
        }
        return Res.ok("定时任务已取消");
    }

    @GetMapping("/start")
    public Res start() {
        String cron = "0/5 * * * * ?";
        schedulerUtils.startTask(taskService.getTaskNo(), taskService, cron);
        log.debug("定时任务开启：taskNo={0}, cron={1}", taskService.getTaskNo(), cron);
        return Res.ok("定时任务已开启");
    }
}

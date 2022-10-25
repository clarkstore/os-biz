package com.onestop.biz.task.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Clark
 * @version 2022/2/28
 */
@Slf4j
@Component
public class BizJob {
    /**
     * 定时任务：业务1
     */
    @Scheduled(cron = "0/7 * * * * ? ")
    public void task1() {
        log.warn("---------业务1--------");
    }

    /**
     * 定时任务：业务2
     */
    @Scheduled(cron = "0/10 * * * * ? ")
    public void task2() {
        log.warn("---------业务2--------");
    }
}

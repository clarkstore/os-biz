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
    @Scheduled(cron = "0/10 * * * * ? ")
    public void job() {
        log.warn("---------BizJob--------");
    }
}

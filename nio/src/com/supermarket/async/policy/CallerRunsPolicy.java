package com.supermarket.async.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @filename:CallerRunsPolicy.java
 *
 *
 * @Description:拒绝策略(由主线程执行该任务)
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public class CallerRunsPolicy extends ThreadPoolExecutor.CallerRunsPolicy {
    /**
     * @param LOGGER
     * @param threadName 线程名
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbortPolicy.class);
    private String threadName;

    public CallerRunsPolicy(){
        this(null);
    }

    public CallerRunsPolicy(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (threadName != null) {
            LOGGER.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }
        super.rejectedExecution(r, executor);
    }
}

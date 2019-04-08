package com.supermarket.async.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @filename:BlockingPolicy.java
 *
 *
 * @Description:拒绝策略(等待队列有可用空间再加入任务)
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public class BlockingPolicy implements RejectedExecutionHandler {
    /**
     * @param LOGGER
     * @param threadName 线程名
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbortPolicy.class);
    private String threadName;

    public BlockingPolicy(){
        this(null);
    }

    public BlockingPolicy(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (threadName != null) {
            LOGGER.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }
        if (!executor.isShutdown()) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {}
        }
    }
}

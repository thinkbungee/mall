package com.supermarket.async.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @filename:AbortPolicy.java
 *
 *
 * @Description:拒绝策略(丢弃任务)
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public class AbortPolicy extends ThreadPoolExecutor.AbortPolicy {

    /**
     * @param LOGGER
     * @param threadName 线程名
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbortPolicy.class);
    private String threadName;

    public AbortPolicy(){
        this(null);
    }

    public AbortPolicy(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (threadName != null) {
            LOGGER.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }
        String msg = String.format("Service["
                        + " Thread Name: %s, Pool Size: %d (active: %d, core: %d, max: %d, largest: %d), Task: %d (completed: %d),"
                        + " Executor status:(isShutdown:%s, isTerminated:%s, isTerminating:%s)]",
                threadName, executor.getPoolSize(), executor.getActiveCount(), executor.getCorePoolSize(), executor.getMaximumPoolSize(), executor.getLargestPoolSize(),
                executor.getTaskCount(), executor.getCompletedTaskCount(), executor.isShutdown(), executor.isTerminated(), executor.isTerminating());
        System.out.println(msg);
        super.rejectedExecution(r, executor);
    }
}

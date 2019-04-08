package com.supermarket.async.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @filename:CallerRunsPolicy.java
 *
 *
 * @Description:拒绝策略(丢弃最早的几个任务立即添加任务)
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public class DiscardedPolicy implements RejectedExecutionHandler {
    /**
     * @param LOGGER
     * @param threadName 线程名
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbortPolicy.class);
    private String threadName;

    public DiscardedPolicy(){
        this(null);
    }

    public DiscardedPolicy(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (threadName != null) {
            LOGGER.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }
        if (!executor.isShutdown()) {
            BlockingQueue<Runnable> queue = executor.getQueue();
            int discard = queue.size() >> 1;
            for (int i=0;i<discard;i++){
                queue.poll();
            }
            queue.offer(r);
        }
    }
}

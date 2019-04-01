package com.supermarket.async;

import com.supermarket.async.policy.*;
import com.supermarket.core.NamedThreadFactory;
import com.supermarket.core.NioSystemConfig;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * @filename:ServiceThreadPool.java
 *
 *
 * @Description:业务线程池
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public class ServiceThreadPool {

    private static RejectedExecutionHandler createPolicy(){
        RejectedPolicyType type = RejectedPolicyType.fromString(System.getProperty(NioSystemConfig.SYSTEM_PROPERTY_THREADPOOL_REJECTED_POLICY_ATTR,"AbortPolicy"));
        switch (type) {
            case ABORT_POLICY:
                return new AbortPolicy();
            case BLOCKING_POLICY:
                return new BlockingPolicy();
            case CALLER_RUNS_POLICY:
                return new CallerRunsPolicy();
            case DISCARDED_POLICY:
                return new DiscardedPolicy();
            case REJECTED_POLICY:
                return new RejectedPolicy();
            default:
                break;
        }
        return null;
    }

    private static BlockingQueue<Runnable> createBlockingQueue(int queues){
        BlockingQueueType qType = BlockingQueueType.fromString(System.getProperty(NioSystemConfig.SYSTEM_PROPERTY_THREADPOOL_QUEUE_NAME_ATTR,"LinkedBlockingQueue"));
        switch (qType) {
            case LINKED_BLOCKING_QUEUE:
                return new LinkedBlockingQueue<Runnable>();
            case ARRAY_BLOCKING_QUEUE:
                return new ArrayBlockingQueue<Runnable>(NioSystemConfig.SYSTEM_PROPERTY_PARALLEL * queues);
            case SYNCHRONOUS_QUEUE:
                return new SynchronousQueue<Runnable>();
            default:
                break;
        }
        return null;
    }

    public static Executor getExecutor(int threads, int queues){
        System.out.println("ThreadPool Core[threads:" + threads + ", queues:" + queues + "]");
        String threadName = "ServiceThreadPool";
        ThreadPoolExecutor executor = new ThreadPoolExecutor(threads, queues, 0, TimeUnit.MILLISECONDS,
                    createBlockingQueue(queues),
                    new NamedThreadFactory(threadName, true),
                    createPolicy()
                );
        return executor;
    }

    public static Executor getExecutorWithJmx(int threads, int queues) {
        final ThreadPoolExecutor executor = (ThreadPoolExecutor) getExecutor(threads, queues);
        return executor;
    }
}

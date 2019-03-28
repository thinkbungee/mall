package com.supermarket.async;

import com.supermarket.async.policy.RejectedPolicyType;
import com.supermarket.core.NioSystemConfig;

import java.util.concurrent.*;

/**
 * @filename:ServiceThreadPool.java
 *
 *
 * @Description:业务处理线程池
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public class ServiceThreadPool {

    private static RejectedExecutionHandler createPolicy(){
        RejectedPolicyType type = RejectedPolicyType.fromString(System.getProperty(NioSystemConfig.SYSTEM_PROPERTY_THREADPOOL_REJECTED_POLICY_ATTR,"AbortPolicy"));
        switch (type) {
            case ABORT_POLICY:
                //return abort
            case BLOCKING_POLICY:
                //return blocking
            case CALLER_RUNS_POLICY:
                //return callerRuns
            case DISCARDED_POLICY:
                //return discarded
            case REJECTED_POLICY:
                //return rejected
            default:
                break;
        }
        return null;
    }

    private static BlockingQueue<Runnable> createBlockingQueue(int queues){
        BlockingQueueType qType = BlockingQueueType.fromString(System.getProperty(NioSystemConfig.SYSTEM_PROPERTY_THREADPOOL_QUEUE_NAME_ATTR,"LinkedBlockingQueue"));
        switch (qType) {
            case LINKED_BLOCKING_QUEUE:
                return new LinkedBlockingQueue<>();
            case ARRAY_BLOCKING_QUEUE:
                return new ArrayBlockingQueue<>(NioSystemConfig.SYSTEM_PROPERTY_PARALLEL * queues);
            case SYNCHRONOUS_QUEUE:
                return new SynchronousQueue<>();
            default:
                break;
        }
        return null;
    }
}

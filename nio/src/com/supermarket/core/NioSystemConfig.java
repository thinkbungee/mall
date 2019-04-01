package com.supermarket.core;

/**
 * @filename:NioSystemConfig.java
 *
 *
 * @Description:系统配置信息
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public class NioSystemConfig {
    public static final String SYSTEM_PROPERTY_THREADPOOL_REJECTED_POLICY_ATTR = "com.supermarket.async.policy";
    public static final String SYSTEM_PROPERTY_THREADPOOL_QUEUE_NAME_ATTR = "com.supermarket.async";
    public static final int SYSTEM_PROPERTY_PARALLEL = Math.max(2, Runtime.getRuntime().availableProcessors());
    public static final int SYSTEM_PROPERTY_THREADPOOL_THREAD_NUMS = Integer.getInteger("nio.default.thread.nums", 16);
    public static final int SYSTEM_PROPERTY_THREADPOOL_QUEUE_NUMS = Integer.getInteger("nio.default.queue.nums", -1);
}

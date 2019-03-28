package com.supermarket.core;

import org.springframework.util.StringUtils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @filename:NamedThreadFactory.java
 *
 *
 * @Description:线程工厂
 * @author dzh
 * @date 2019.03.27
 * @version 1.0
 */
public class NamedThreadFactory implements ThreadFactory {
    /**
     * @param THREAD_NUMBER    当前线程数
     * @param mThreadNum       当前线程数(创建线程)
     * @param prefix           线程名前缀
     * @param daemoThread      是否启用守护线程
     * @param threadGroup      线程组
     */
    private static final AtomicInteger THREAD_NUMBER = new AtomicInteger(1);
    private final  AtomicInteger mThreadNum = new AtomicInteger(1);
    private final String prefix;
    private final boolean daemoThread;
    private final ThreadGroup threadGroup;

    NamedThreadFactory(){
        this("supermarket-nio-threadpool-" + THREAD_NUMBER.getAndIncrement());
    }

    NamedThreadFactory(String prefix){
        this(prefix, false);
    }

    NamedThreadFactory(String prefix, boolean daemo){
        this.prefix = StringUtils.isEmpty(prefix) ? prefix + "-thread-" : "";
        daemoThread = daemo;
        SecurityManager s = System.getSecurityManager();
        threadGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable r) {
        String threadName = this.prefix + mThreadNum.getAndIncrement();
        Thread thread = new Thread(threadGroup, r, threadName, 0);
        thread.setDaemon(daemoThread);
        return thread;
    }

    public ThreadGroup getThreadGroup() {
        return threadGroup;
    }
}

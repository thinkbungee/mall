package com.supermarket.async.policy;

/**
 * @filename:RejectedRunnable.java
 *
 *
 * @Description:拒绝策略线程
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public interface RejectedRunnable extends Runnable {
    void rejected();
}

package com.supermarket.juc;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0 created by chenyichang_fh on 2019/5/15 22:31
 */
public class DeadThreadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"AAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"BBB").start();
    }
}

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "自己持有" + lockA + "，尝试获取" + lockB);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (Exception e) {
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "自己持有" + lockB + ",尝试获取" + lockA);
            }
        }

    }
}

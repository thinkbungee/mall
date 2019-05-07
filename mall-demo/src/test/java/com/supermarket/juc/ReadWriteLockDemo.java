package com.supermarket.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @version 1.0 created by chenyichang_fh on 2019/4/26 15:21
 */
class Mycash {
    private volatile Map map = new HashMap();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写入:" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (Exception e) {
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } catch (Exception e) {
        } finally {
            lock.writeLock().unlock();
        }

    }

    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取:");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (Exception e) {
            }
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成 ：" + value);
        } catch (Exception e) {
        } finally {
            lock.readLock().unlock();
        }

    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        Mycash mycash = new Mycash();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                mycash.put(temp + "", temp);
            }, i + "").start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                mycash.get(temp + "");
            }, i + "").start();
        }
    }
}

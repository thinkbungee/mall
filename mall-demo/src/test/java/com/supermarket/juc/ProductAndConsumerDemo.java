package com.supermarket.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者模型 传统版
 * sync  ---  wait   ---  notify（第一种）
 * lock  ---  await  ---  signal（第二种）
 *
 * 题目：一个初始值为0的变量，两个线程交替操作，一个加1，一个减1
 *
 * 思路：
 * 1.线程--操作资源类
 * 2. 判断---干活---通知
 * 3.防止虚假唤醒机制（判断使用while，不能使用if）
 * @version 1.0 created by chenyichang_fh on 2019/5/12 16:21
 */
public class ProductAndConsumerDemo {
    public static void main(String[] args) {
        Number number = new Number();
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                number.increment();
            }, "AA").start();
        }
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                number.decrement();
            }, "BB").start();
        }
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                number.increment();
            }, "CC").start();
        }
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                number.decrement();
            }, "DD").start();
        }
    }
}
class Number {
    private int i = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (i != 0) {
                //等待,不能生产
                condition.await();
            }
            //生产
            i++;
            System.out.println(Thread.currentThread().getName() +"\t" + this.i);
            condition.signalAll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (i == 0) {
                //等待,不能消费
                condition.await();
            }
            //消费
            i--;
            System.out.println(Thread.currentThread().getName() +"\t" + this.i);
            condition.signalAll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }

    }
}

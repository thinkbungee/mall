package com.supermarket.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 多线程之间按顺序调用，实现A-->B-->C三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 * 紧接着
 * A打印5次，B打印10次，C打印15次
 * 。。。
 * 一直循环10轮
 * @version 1.0 created by chenyichang_fh on 2019/5/12 21:43
 */
public class LockAndMoreConditionDemo {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                data.print5();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                data.print10();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                data.print15();
            }
        }, "C").start();
    }
}

class Data {
    public int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void print5() {
        //========标志位为1=======//
        lock.lock();
        try {
            while (number != 1) {
                //需要等待
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;//唤醒标志为2的线程
            c2.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }

    }

    public void print15() {
        //========标志位为3=======//
        lock.lock();
        try {
            while (number != 3) {
                //需要等待
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;//标志为2的线程
            c1.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        //========标志位为2=======//
        lock.lock();
        try {
            while (number != 2) {
                //需要等待
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;//标志为2的线程
            c3.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}

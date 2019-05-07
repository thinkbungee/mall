package com.supermarket.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    volatile int i =  0;
    public void mylock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "   come in");

        while (!atomicReference.compareAndSet(null, thread)) {
        }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + " free lock");
    }


    public static void main(String[] args) {
        SpinLockDemo demo = new SpinLockDemo();

        new Thread(() -> {
            demo.mylock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
            }
            demo.myUnlock();
        }, "AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }

        new Thread(() -> {
            demo.mylock();
            demo.myUnlock();
        }, "BB").start();
    }
}
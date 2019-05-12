package com.supermarket.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0 created by chenyichang_fh on 2019/5/8 14:06
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        //模拟7辆车抢5个车位
        //demo1(semaphore);
    }


    private static void demo1(Semaphore semaphore) {
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    try {
                        TimeUnit.MILLISECONDS.sleep(3000);
                    } catch (Exception e) {

                    }
                    System.out.println(Thread.currentThread().getName() + "停了3秒钟，并离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}

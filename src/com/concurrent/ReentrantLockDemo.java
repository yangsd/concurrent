package com.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * java.util.concurrent.lock包中提供了对锁的支持
 * 为使用synchronized控制对资源访问提供了替代机制
 * 基本操作模型： 访问资源之前申请锁，访问完毕后释放锁
 * lock/tryLock: 申请锁
 * unlock: 释放锁
 * 具体锁类ReentrantLock实现了Lock接口
 *
 * 原子操作
 * java.util.concurrent.atom包中提供了对原子操作的支持
 * 提供了不需要锁以及其他同步机制就可以进行的一些不可中断操作
 * 主要操作为：获取、设置、比较等
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        new MT().start();
        new MT().start();
        new MT().start();
        new MT().start();
    }

}

class Data {

    static int i = 0;
    static Lock lock = new ReentrantLock();
    static AtomicInteger ai = new AtomicInteger(0);

    static void operate() {
        System.out.println(ai.incrementAndGet());
//        lock.lock();
//        i++;
//        System.out.println(i);
//        lock.unlock();
    }

}

class MT extends Thread {
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Data.operate();
        }
    }
}

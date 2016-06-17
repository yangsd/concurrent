package com.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier同步器
 * 适用于只有多个线程都到达预定点时才可以继续执行
 * CyclicBarrier(int num)：等待线程的数量
 * CyclicBarrier(int num,Runnable action)：等待线程的数量以及所有线程到达后的操作
 * await()：到达临界点后暂停线程
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Game start");
            }
        });

        new Player(cyclicBarrier, "A").start();
        new Player(cyclicBarrier, "B").start();
        new Player(cyclicBarrier, "C").start();
    }

}

class Player extends Thread {
    private CyclicBarrier cyclicBarrier;
    public Player(CyclicBarrier cyclicBarrier, String name) {
        setName(name);
        this.cyclicBarrier = cyclicBarrier;
    }
    public void run() {
        System.out.println(getName() + " is waiting other players....");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}

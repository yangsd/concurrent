package com.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 计数信号量Semaphore
 * 通过计数器控制对共享资源的访问
 * Semaphore(int count)：创建拥有count个许可证的信号量
 * acquire()/acquire(int num)：获取1/num个许可证
 * release()/release(int num)：释放1/num个许可证
 */
public class SemaphoreDemo {

    public static void main(String [] args) {
        Semaphore semaphore = new Semaphore(2);

        Person p1 = new Person(semaphore, "A");
        p1.start();
        Person p2 = new Person(semaphore, "B");
        p2.start();
        Person p3 = new Person(semaphore, "C");
        p3.start();
    }

}

class Person extends Thread {

    private Semaphore semaphore;

    public Person(Semaphore semaphore, String name) {
        setName(name);
        this.semaphore = semaphore;
    }

    public void run() {
        System.out.println(getName() + " is waiting ....");
        try {
            semaphore.acquire();
            System.out.println(getName() + " is servicing...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " is done!");
        semaphore.release();
    }

}

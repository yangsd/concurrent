package com.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 执行器
 * 用于启动并控制线程的执行。
 * 核心接口为Executor，包含一个execute(Runnable) 方法用于指定被执行的线程
 * ExecutorService接口用于控制线程执行和管理线程
 * 预定义了如下执行器类：
 * ThreadPoolExecutor/ScheduledThreadPoolExecutor/ForkJoinPool
 *
 * Callable与Future
 * Callable<V>:  表示具有返回值的线程
 * V: 表示返回值的类型
 * call(): 执行任务
 * Future<V>: 表示由Callable返回的值
 * V: 返回值类型
 * get(): 获取返回值
 */
public class CallableFutureDemo{

    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> r1 = es.submit(new MC(1, 100));
        Future<Integer> r2 = es.submit(new MC(100, 10000));

        System.out.println(r1.get() + ":" + r2.get());

        es.shutdown();
    }

}

class MC implements Callable<Integer> {

    private int begin, end;
    public MC(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = begin; i < end; i++)
            sum += i;
        return sum;
    }
}

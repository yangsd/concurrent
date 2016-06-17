并发工具概述 -- 各组成部分及作用

同步器：为每种特定的同步问题提供了解决方案
执行器：用来管理线程的执行
并发集合：提供了集合框架中集合的并发版本
Fork/Join框架：提供了对并行编程的支持
atomic包：提供了不需要锁即可完成并发环境变量使用的原子性操作
locks包：使用Lock接口为并发编程提供了同步的另外一种替代方案



Executor类构建线程池的静态方法
     方法	                                   描述
newCachedThreadPool	                必要时创建新线程，空闲线程会被保留60秒
newFixedThreadPool	                该池包含固定数量的线程；空闲线程会一直被保留
newSingleThreadExecutor	            只有一个线程的“池”，该线程顺序执行每一个提交的任务
newScheduledThreadPool	            用于预定执行而构建的固定线程池，替代java.util.Timer
newSingleThreadScheduledExecutor	用于预定执行而构建的单线程“池”
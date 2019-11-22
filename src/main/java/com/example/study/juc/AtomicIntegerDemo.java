package com.example.study.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 原子引用类
 *  不能用默认的线程池工具类 创建线程池
 *
 * @author: caoyangfan
 * @create: 2019-11-15 15:15
 **/
public class AtomicIntegerDemo {
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        //NonReentrantLock nonReentrantLock = new NonReentrantLock();
        readLock.lock();

        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        ExecutorService executorService3 = Executors.newWorkStealingPool();

        AtomicInteger  atomicInteger = new AtomicInteger(100);
        int i = atomicInteger.get();
        int update = i + 200;
        boolean b = atomicInteger.compareAndSet(i, update);
        atomicInteger.getAndAdd(200);
    }


    public static void get(){
        readLock.lock();
    }

    public static void set(){
        writeLock.lock();
    }
}

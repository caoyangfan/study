package com.example.study.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 火箭发射倒计时
 *
 * @author: caoyangfan
 * @create: 2019-10-17 19:59
 **/
public class CountDownLatchDemo {



    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Lock lock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        Exchanger<Integer> exchanger = new Exchanger<>();

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();



    }
}

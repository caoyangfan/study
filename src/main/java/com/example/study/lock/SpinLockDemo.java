package com.example.study.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自己实现
 * 自旋锁
 * atomicReference
 *
 * @author: caoyangfan
 * @create: 2019-10-17 17:00
 **/
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        // 当前线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in ");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myunLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoke myunLock ");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() ->{
            try {
                spinLockDemo.myLock();
                TimeUnit.SECONDS.sleep(5);
                spinLockDemo.myunLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"aaa").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() ->{
            try {
                spinLockDemo.myLock();
                TimeUnit.SECONDS.sleep(2);
                spinLockDemo.myunLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"bbb").start();
    }
}

package com.example.study.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition
 * 呼啦圈
 *
 * @author: caoyangfan
 * @create: 2019-10-17 15:23
 **/
public class ReLockDemo {

    private Lock lock = new ReentrantLock();

    private int totalLoopA = 10;
    private int totalLoopB = 10;
    private int totalLoopC = 10;
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    private int loopA = 1;
    private int loopB = 2;
    private int loopC = 3;

    public static void main(String[] args) {
        ReLockDemo reLockDemo = new ReLockDemo();
        LoopA loopA = reLockDemo.new LoopA();
        LoopB loopB = reLockDemo.new LoopB();
        LoopC loopC = reLockDemo.new LoopC();
        Thread t1 = new Thread(loopA);
        Thread t2 = new Thread(loopB);
        Thread t3 = new Thread(loopC);
        t1.start();
        t2.start();
        t3.start();
    }

    class LoopA implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                while (totalLoopA > 0) {
                    for (int i = 0; i < loopA; i++) {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("AAAAAAAAAA " + totalLoopA);
                    }
                    c2.signal();
                    c1.await();
                    totalLoopA--;
                }
                System.out.println(Thread.currentThread().getName() + " over");
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }


    class LoopB implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                lock.lock();
                while (totalLoopB > 0) {
                    c2.await();
                    for (int i = 0; i < loopB; i++) {
                        System.out.println("BBBBBBBBBB " + totalLoopB);
                    }
                    totalLoopB--;
                    c3.signal();
                }
                System.out.println(Thread.currentThread().getName() + " over");
            } catch (Exception e) {

            } finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }


    class LoopC implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                lock.lock();
                while (totalLoopC > 0) {
                    c3.await();
                    for (int i = 0; i < loopC; i++) {
                        System.out.println("CCCCCCCCCC " + totalLoopC);

                    }
                    totalLoopC--;
                    c1.signal();
                }
                System.out.println(Thread.currentThread().getName() + " over");
            } catch (Exception e) {

            } finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }

}

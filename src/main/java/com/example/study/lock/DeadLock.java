package com.example.study.lock;

/**
 * @author: caoyangfan
 * @create: 2019-10-18 11:27
 *
 * 死锁代码
 * 及其如何排查
 *
 *
 * jps -l
 * jstack PID
 *
 **/

class ShareData implements Runnable{

    private String lockA;
    private String lockB;

    public ShareData(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"锁"+lockA+",尝试获取锁"+lockB);
            synchronized (lockB){
            }
        }
    }
}

public class DeadLock {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        ShareData shareData = new ShareData(lockA,lockB);
        ShareData shareData2 = new ShareData(lockB,lockA);
        new Thread(shareData).start();
        new Thread(shareData2).start();
    }
}

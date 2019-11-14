package com.example.study.lock;

import java.util.concurrent.TimeUnit;

/**
 * DCL 双端检索模式
 *
 * @author: caoyangfan
 * @create: 2019-11-14 11:03
 **/
public class SingletonDemo {

    private volatile static SingletonDemo instance = null;
    private SingletonDemo(){
    }

    public static SingletonDemo getInstance(){
        if(instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new SingletonDemo();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis()/1000);

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonDemo.getInstance());
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            //System.out.println(Thread.activeCount());
            continue;
        }
        System.out.println(System.currentTimeMillis()/1000);
    }
}

package com.example.study.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁   AB(After Before),缓存
 * <p>
 * 读读共存
 * 读写不共存
 * 写写不共存
 * memacache redis 同读同写
 *
 * @author: caoyangfan
 * @create: 2019-10-17 17:49
 **/
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        Mycache mycache = new Mycache();
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                mycache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                mycache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}


class Mycache {

    private volatile Map<String, Object> map = new HashMap<>();

    //private Lock lock = new ReentrantLock();

    private ReentrantReadWriteLock rwLock =  new ReentrantReadWriteLock();
    public void put(String key, Object value) {

        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入:" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成:" + key);
        } catch (Exception e) {

        } finally {
            rwLock.writeLock().unlock();
        }

    }

    public Object get(String key) {
        rwLock.readLock().lock();
        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取:" + key);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成:" + result);

        } catch (Exception e) {

        } finally {
            rwLock.readLock().unlock();
        }
        return result;
    }

}
package com.example.study.juc;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author: caoyangfan
 * @create: 2019-10-23 17:13
 **/
public class ShowMainThread {

    /**
     * 运行结果
     *
     * 6:Monitor Ctrl-Break
     * 5:Attach Listener
     * 4:Signal Dispatcher
     * 3:Finalizer
     * 2:Reference Handler
     * 1:main
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo:threadInfos){
            System.out.println(threadInfo.getThreadId()+":"+threadInfo.getThreadName());
        }
    }

    /**
     * 5:Attach Listener  //获取内存dump,线程dump
     *
     * 4:Signal Dispatcher  //将信号分发给jvm的线程
     *
     * 3:Finalizer  //调用对象的finalizer 方法 进行垃圾回收
     *
     * 2:Reference Handler  //清除Reference
     *
     * 1:main //程序的主入口
     */
}

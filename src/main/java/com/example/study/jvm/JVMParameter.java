package com.example.study.jvm;

/**
 * @author: caoyangfan
 * @create: 2019-10-18 11:25
 *
 * Jvm的参数类型
 * 标配参数
 * java -version java -help java -showversion
 *
 * X参数
 * -Xint  解释自行
 * -Xcomp  第一次使用就编译成本地代码
 * -Xmixed 混合模式
 *
 * XX参数
 * Boolean 类型 -xx:+或者-某个属性值
 * +表示开启
 * -表示关闭
 *
 * case 是否打印GC收集细节
 *
 * kv设置类型
 *
 * jps -l 查询进程编号 PID
 * jinfo举例，如何查看当前运行程序的配置
 *
 * jinfo -flag  PrintGCDetails PID
 * jinfo -flags PID
 * XX参数重点
 *
 * -Xms1024m -Xmx1024m  (Xms Xmx并不属于X参数,而是属于XX参数)
 * -Xms 等价于 -XX:InitialHeapSize
 * -Xmx 等价于 -XX:MaxHeapSize
 * java -XX:+PrintFlagsInitial 查看盘点家族
 **/
public class JVMParameter {
}


/**
 * 对 GCRoot的理解  tracingGC  集合的引用
 *
 * 什么事GCRoot？
 * GCroot对象？
 * 四种对象
 *  native方法
 * 方法区 常量  和 类的静态属性
 * 栈里局部变量表引用的对象
 *
 * 如何确认是垃圾
 *
 *
 * Monitorenter  monitorexit
 */


/**
 * Java8 jvm
 *
 *
 * Eden  survivor0  survivor1 old  metaspace元空间
 *
 *
 * 可达性分析 死环
 * 引用计数   没有用的
 * 复制   年轻代
 * 标记清除 mark sweep （产生了内存碎片） 老生代多一些
 * 标记整理（标记压缩） 老生代多一些
 *
 * 分代收集算法 没有哪一种算法是靠谱的
 */
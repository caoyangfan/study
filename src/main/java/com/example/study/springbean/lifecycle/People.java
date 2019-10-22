package com.example.study.springbean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * 参考连接 https://www.jianshu.com/p/252cf9fc67d0
 *
 * spring bean的生命周期
 *
 * com.example.study.configuration.BeanConfiguration中配置People bean
 * 的initMethod,destoryMethod
 *
 * @author: caoyangfan
 * @create: 2019-10-22 17:25
 **/
public class People implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public void customInit(){
        System.out.println("自定义初始化方法 customInit");
    }

    public void customDestory(){
        System.out.println("自定义销毁方法 customDestory");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

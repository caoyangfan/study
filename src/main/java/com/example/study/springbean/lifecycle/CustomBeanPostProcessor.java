package com.example.study.springbean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: caoyangfan
 * 还可以通过实现 CustomBeanPostProcessor，来自定义后处理器，
 * 我们可以针对那些感兴趣的 Bean 进行加工处理
 *
 * @create: 2019-10-22 17:41
 **/
public class CustomBeanPostProcessor implements BeanPostProcessor {
    public static final String PEOPLE_BEAN = "people";

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals(PEOPLE_BEAN)) {
            People people = (People) bean;
            if (people.getName() == null) {
                people.setName("deniro");
                System.out.println("postProcessBeforeInitialization："+people);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals(PEOPLE_BEAN)) {
            People people = (People) bean;
            if (people.getAge() == 0) {
                people.setAge(25);
                System.out.println("postProcessAfterInitialization："+people);
            }
        }
        return bean;
    }
}

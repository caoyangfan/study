package com.example.study.springbean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @author: caoyangfan
 * @create: 2019-10-22 17:35
 **/
public class CustomInstantiationAwareBeanPostProcessor extends
        InstantiationAwareBeanPostProcessorAdapter
{
    public static final String PEOPLE_BEAN = "people";

    /**
     * 在实例化 Bean 之前调用
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (PEOPLE_BEAN.equals(beanName)) {
            System.out.println("postProcessBeforeInstantiation");
        }
        return null;
    }

    /**
     * 在实例化 Bean 之后调用
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (PEOPLE_BEAN.equals(beanName)) {
            System.out.println("postProcessAfterInstantiation");
        }
        return true;
    }

    /**
     * 设置某个属性
     *
     * @param pvs
     * @param pds
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (PEOPLE_BEAN.equals(beanName)) {
            System.out.println("postProcessPropertyValues");
        }
        return pvs;
    }

}

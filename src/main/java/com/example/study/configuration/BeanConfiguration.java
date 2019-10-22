package com.example.study.configuration;

import com.example.study.springbean.lifecycle.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: caoyangfan
 * @create: 2019-10-22 17:31
 **/

@Configuration
public class BeanConfiguration {

    @Bean(initMethod="customInit",destroyMethod = "customDestory")
    public People people(){
        return new People();
    }
}

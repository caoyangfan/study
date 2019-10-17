package com.example.study.controller;

import com.example.study.exception.Error;
import com.example.study.exception.SpittleNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: caoyangfan
 * @create: 2019-10-07 17:43
 **/
@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(SpittleNotFoundException.class)
    public Error spittleNotFound(SpittleNotFoundException e){
        long spittleId = e.getSpittledId();
        return new Error(4,"Spittle ["+spittleId +"] not found");
    }
}

package com.example.study.controller;

import com.example.study.exception.Error;
import com.example.study.exception.SpittleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: caoyangfan
 * @create: 2019-10-07 17:43
 **/
//@ControllerAdvice
public class BaseControllerAdvice2 {

    /**
     * 如果错误处理器方法始终返回Error,并且HTTP状态码为404(Not Found),那么现在我们可以对spittleNotFound()方法进行类似的清理
     * 去掉ResponseEntity
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SpittleNotFoundException.class)
    public @ResponseBody ResponseEntity<Error> spittleNotFound(SpittleNotFoundException e){
        long spittleId = e.getSpittledId();
        Error error = new Error(4,"Spittle ["+spittleId +"] not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

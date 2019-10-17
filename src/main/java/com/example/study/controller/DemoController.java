package com.example.study.controller;

import com.example.study.bean.Spittle;
import com.example.study.exception.SpittleNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一处理异常demo
 *
 * @author: caoyangfan
 * @create: 2019-10-07 17:41
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Spittle spittleById(@PathVariable long id){
        Spittle spittle = null;
        if (id == 1){
            spittle = new Spittle("赵云","常山赵子龙");
        }
        if(spittle == null){
            throw new SpittleNotFoundException(id);
        }
        return spittle;
    }

}

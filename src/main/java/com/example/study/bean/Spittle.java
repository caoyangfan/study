package com.example.study.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: caoyangfan
 * @create: 2019-10-07 18:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spittle implements Serializable {
    private static final long serialVersionUID = 8302544997752498586L;

    private String name;
    private String description;

}

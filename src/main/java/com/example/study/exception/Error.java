package com.example.study.exception;

/**
 * @author: caoyangfan
 * @create: 2019-10-07 17:45
 **/
public class Error {

    private int code;
    private String message;

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

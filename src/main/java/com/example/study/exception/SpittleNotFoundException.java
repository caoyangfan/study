package com.example.study.exception;

/**
 * @author: caoyangfan
 * @create: 2019-10-07 17:42
 **/
public class SpittleNotFoundException extends RuntimeException {

    private long spittleId;

    public SpittleNotFoundException(long spittleId){
        this.spittleId = spittleId;
    }

    public long getSpittledId() {
        return spittleId;
    }
}

package com.lrx.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lrx
 * {@code @date} 2025/3/18 下午10:06
 */
@ResponseStatus(reason="年龄需要在 1-120 之间 ",value= HttpStatus.BAD_REQUEST)
public class AgeException extends RuntimeException{

    public AgeException() {

    }
    public AgeException(String message) {
        super(message);
    }
}

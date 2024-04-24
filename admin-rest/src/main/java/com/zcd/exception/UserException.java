package com.zcd.exception;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 4:34 pm
 */
public class UserException extends  RuntimeException{

    public UserException() {
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}

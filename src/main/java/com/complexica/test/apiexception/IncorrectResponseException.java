package com.complexica.test.apiexception;

/**
 * Created by feiyang on 2/10/21.
 */
public class IncorrectResponseException extends RuntimeException {
    public IncorrectResponseException(String message, Throwable err){
        super(message, err);
    }
}

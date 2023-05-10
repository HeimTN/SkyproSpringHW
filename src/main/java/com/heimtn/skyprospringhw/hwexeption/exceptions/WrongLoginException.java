package com.heimtn.skyprospringhw.hwexeption.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class WrongLoginException extends Exception{
    public WrongLoginException(String message){
        super(message);
    }
}

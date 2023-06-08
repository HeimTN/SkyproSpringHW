package com.heimtn.skyprospringhw.hwcollections2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnCorrectStringException extends RuntimeException{
    public UnCorrectStringException(String msg){super(msg);}
}

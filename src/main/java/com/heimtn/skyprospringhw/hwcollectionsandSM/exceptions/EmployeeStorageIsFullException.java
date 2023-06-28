package com.heimtn.skyprospringhw.hwcollectionsandSM.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message){
        super(message);
    }
}

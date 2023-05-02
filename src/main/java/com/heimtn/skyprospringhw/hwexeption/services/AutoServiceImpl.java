package com.heimtn.skyprospringhw.hwexeption.services;

import com.heimtn.skyprospringhw.hwexeption.exceptions.WrongLoginException;
import com.heimtn.skyprospringhw.hwexeption.exceptions.WrongPasswordException;
import org.springframework.stereotype.Service;

@Service
public class AutoServiceImpl implements AutoService{
    @Override
    public void autorization(String login, String password, String confirmPassword) {
        if (login.length() > 20){
            throw new WrongLoginException();
        }
        if(password.length() >= 20){
            throw new WrongPasswordException();
        }
        if( password.equals(confirmPassword)) {
            System.out.println("Все круто!");
        }
        else throw new WrongPasswordException();
    }
}

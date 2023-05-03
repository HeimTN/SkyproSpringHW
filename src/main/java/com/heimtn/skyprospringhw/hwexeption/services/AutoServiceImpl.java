package com.heimtn.skyprospringhw.hwexeption.services;


import org.springframework.stereotype.Service;

@Service
public class AutoServiceImpl implements AutoService{
    @Override
    public boolean autoLogin(String login) {
        return login.length() <= 20 && login.length() > 0 && checkStr(login);
    }

    @Override
    public boolean autoPass(String password, String confirmPassword) {
        return password.length() < 20 && password.length() > 0 && password.equals(confirmPassword) && checkStr(password);
    }

    private boolean checkStr(String str){
        if(str.matches("^[a-zA-Z0-9\\_]*$")) return true;
        else return false;
    }
}

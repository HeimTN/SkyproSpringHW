package com.heimtn.skyprospringhw.hwexeption.controllers;

import com.heimtn.skyprospringhw.hwexeption.exceptions.WrongLoginException;
import com.heimtn.skyprospringhw.hwexeption.exceptions.WrongPasswordException;
import com.heimtn.skyprospringhw.hwexeption.services.AutoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auto")
public class AutorizationController {

    private final AutoService autoService;

    public AutorizationController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public String autorization(@RequestParam String login, @RequestParam String password, @RequestParam String confirmPassword)
    throws WrongPasswordException,WrongLoginException {
        if(autoService.autoLogin(login) && autoService.autoPass(password, confirmPassword)) return "Все ок";
        else {
            if (autoService.autoLogin(login)) throw new WrongPasswordException("Неправильный пароль");
            else throw new WrongLoginException("Неправильный логин");
        }
    }


}
//?login=kakoi_to_1&password=ZdaroVa_0tes&confirmPassword=ZdaroVa_0tes
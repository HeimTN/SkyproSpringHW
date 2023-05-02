package com.heimtn.skyprospringhw.hwexeption.controllers;

import com.heimtn.skyprospringhw.hwexeption.exceptions.WrongLoginException;
import com.heimtn.skyprospringhw.hwexeption.exceptions.WrongPasswordException;
import com.heimtn.skyprospringhw.hwexeption.services.AutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auto")
public class AutorizationController {

    private final AutoService autoService;

    public AutorizationController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public void autorization(@RequestParam String login, @RequestParam String password, @RequestParam String confirmPassword){
        try {
            autoService.autorization(login, password, confirmPassword);
        }catch (WrongLoginException e){
            System.out.println("Неверный логин");
        }catch (WrongPasswordException e){
            System.out.println("Неверный пароль");
        }
    }
}
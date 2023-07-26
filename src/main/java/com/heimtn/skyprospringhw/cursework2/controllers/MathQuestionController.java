package com.heimtn.skyprospringhw.cursework2.controllers;

import com.heimtn.skyprospringhw.cursework2.exceptions.MethodNotAllowedException;
import com.heimtn.skyprospringhw.cursework2.objects.Question;
import com.heimtn.skyprospringhw.cursework2.services.MathQuestionService;
import com.heimtn.skyprospringhw.cursework2.services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private QuestionService service;

    public MathQuestionController(MathQuestionService mathQuestionService){
        this.service = mathQuestionService;
    }

    @GetMapping
    public Collection<Question> allQuestion(){
        return service.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer){
        throw new MethodNotAllowedException("На данный момент добавление математических вопросов не доступно");
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer){
        throw new MethodNotAllowedException("На данный момент добавление математических вопросов не доступно");
    }
}

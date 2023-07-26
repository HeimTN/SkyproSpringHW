package com.heimtn.skyprospringhw.cursework2.controllers;

import com.heimtn.skyprospringhw.cursework2.objects.Question;
import com.heimtn.skyprospringhw.cursework2.services.ExaminerService;
import com.heimtn.skyprospringhw.cursework2.services.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExaminerService service;

    public ExamController(ExaminerServiceImpl examinerService){
        this.service = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount){
        return service.getQuestions(amount);
    }
}

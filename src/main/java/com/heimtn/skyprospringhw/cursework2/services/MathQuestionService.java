package com.heimtn.skyprospringhw.cursework2.services;

import com.heimtn.skyprospringhw.cursework2.objects.Question;
import com.heimtn.skyprospringhw.cursework2.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("mathS")
public class MathQuestionService implements QuestionService{
    private QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("math") QuestionRepository repository){
        this.questionRepository = repository;
    }


    @Override
    public Question add(String question, String answer) {
        return questionRepository.add(question,answer);
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int a = random.nextInt(0, 255);
        int b = random.nextInt(0, 255);
        int action = random.nextInt(0, 4);
        int result;
        switch (action){
            default: result = a + b;
                return new Question(a + " + " + b + " =", " " + result );
            case 1: result = a - b;
                return new Question(a + " - " + b + " =", " " + result );
            case 2: result = a * b;
                return new Question(a + " * " + b + " =", " " + result );
            case 3: if(b == 0){ result = a;
                return new Question(a + " / 1" + " =", " " + result );}
                    else{ result = a / b;
                return new Question(a + " / " + b + " =", " " + result );}
        }

    }
}

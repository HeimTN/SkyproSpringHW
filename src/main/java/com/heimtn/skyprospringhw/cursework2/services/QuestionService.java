package com.heimtn.skyprospringhw.cursework2.services;

import com.heimtn.skyprospringhw.cursework2.objects.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}

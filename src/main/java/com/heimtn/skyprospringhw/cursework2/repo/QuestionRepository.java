package com.heimtn.skyprospringhw.cursework2.repo;

import com.heimtn.skyprospringhw.cursework2.objects.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}

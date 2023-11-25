package com.heimtn.skyprospringhw.cursework2.repo;

import com.heimtn.skyprospringhw.cursework2.exceptions.MathQuestionException;
import com.heimtn.skyprospringhw.cursework2.objects.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Repository
@Qualifier("math")
public class MathQuestionRepository implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init(){
        add("MathQText", "MathAText");
        add("MathQText1", "MathAText1");
        add("MathQText2", "MathAText2");
        add("MathQText3", "MathAText3");
        add("MathQText4", "MathAText4");
        add("MathQText5", "MathAText5");
    }

    @Override
    public Question add(String question, String answer) {
        if(question != null && answer != null){
            Question temp = new Question(question, answer);
            if(questions.add(temp)) return temp;
            else throw new MathQuestionException("Такой вопрос уже есть в базе");
        }
        throw new MathQuestionException("Вопрос или ответ не должны быть null");
    }

    @Override
    public Question add(Question question) {
        if(question != null){
            if(questions.add(question)) return question;
            else throw new MathQuestionException("Такой вопрос уже есть в базе");
        }
        throw new MathQuestionException("Вопрос не должен быть null");
    }

    @Override
    public Question remove(Question question) {
        if(questions.contains(question)){
            questions.remove(question);
            return question;
        }
        throw new MathQuestionException("Такого вопроса нет в базе");
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}

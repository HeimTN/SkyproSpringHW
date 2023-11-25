package com.heimtn.skyprospringhw.cursework2.repo;

import com.heimtn.skyprospringhw.cursework2.exceptions.JavaQuestionException;
import com.heimtn.skyprospringhw.cursework2.objects.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
@Qualifier("java")
public class JavaQuestionRepository implements QuestionRepository{
    private Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init(){
        add("JavaQText", "JavaAText");
        add("JavaQText1", "JavaAText1");
        add("JavaQText2", "JavaAText2");
        add("JavaQText3", "JavaAText3");
        add("JavaQText4", "JavaAText4");
        add("JavaQText5", "JavaAText5");
    }



    @Override
    public Question add(String question, String answer) {
        if(question != null && answer != null){
            Question temp = new Question(question, answer);
            if(questions.add(temp)) return temp;
            else throw new JavaQuestionException("Такой вопрос уже есть в базе");
        }
        throw new JavaQuestionException("Вопрос или ответ не должны быть null");
    }

    @Override
    public Question add(Question question) {
        if(question != null){
            if(questions.add(question)) return question;
            else throw new JavaQuestionException("Такой вопрос уже есть в базе");
        }
        throw new JavaQuestionException("Вопрос не должен быть null");
    }

    @Override
    public Question remove(Question question) {
        if(questions.contains(question)){
            questions.remove(question);
            return question;
        }
        throw new JavaQuestionException("Такого вопроса нет в базе");
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}

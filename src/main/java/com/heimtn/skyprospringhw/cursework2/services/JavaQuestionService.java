package com.heimtn.skyprospringhw.cursework2.services;

import com.heimtn.skyprospringhw.cursework2.exceptions.JavaQuestionException;
import com.heimtn.skyprospringhw.cursework2.objects.Question;
import com.heimtn.skyprospringhw.cursework2.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("javaS")
public class JavaQuestionService implements QuestionService{
    private QuestionRepository questionRepository;

    public JavaQuestionService(@Qualifier("java") QuestionRepository repository){
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
        if(getAll().size() == 0){
            throw new JavaQuestionException("Билетов нет");
        }
        else {
            Random random = new Random();
            List<Question> questionList = getAll().stream().toList();
            Question result = questionList.get(random.nextInt(0, questionList.size()+1));
            if (result != null) {
                return result;
            } else return getRandomQuestion();
        }
    }
}

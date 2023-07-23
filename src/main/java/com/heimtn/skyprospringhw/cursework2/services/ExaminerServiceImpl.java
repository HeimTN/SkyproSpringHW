package com.heimtn.skyprospringhw.cursework2.services;

import com.heimtn.skyprospringhw.cursework2.exceptions.LargeQuantityRequestException;
import com.heimtn.skyprospringhw.cursework2.objects.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private Collection<QuestionService> questionServices = new ArrayList<>();
    private final Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("javaS") QuestionService questionService1,
                               @Qualifier("mathS") QuestionService questionService2){
        this.questionServices.add(questionService1);
        this.questionServices.add(questionService2);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        AtomicInteger countQuest = new AtomicInteger();
        questionServices.stream().forEach(e -> countQuest.set(countQuest.get() + e.getAll().size()));
        if(countQuest.get() >= amount){
            Set<Question> result = new HashSet<>();
            List<QuestionService> temp = questionServices.stream().toList();
            for (int i = 0; i < amount; i++) {
                //result = addQuestionInCollection(result);
                result.add(temp.get(random.nextInt(0, temp.size())).getRandomQuestion());
            }
            return result;
        }
        throw new LargeQuantityRequestException("Такого количества вопросов нет");
    }

    private Set<Question> addQuestionInCollection(Set<Question> collection){
        List<QuestionService> temp = questionServices.stream().toList();
        if (collection.add(temp.get(random.nextInt(0, temp.size())).getRandomQuestion())) {
            return collection;
        } else return addQuestionInCollection(collection);
    }
}

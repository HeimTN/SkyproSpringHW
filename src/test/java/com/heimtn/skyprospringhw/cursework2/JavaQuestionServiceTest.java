package com.heimtn.skyprospringhw.cursework2;

import com.heimtn.skyprospringhw.cursework2.exceptions.JavaQuestionException;
import com.heimtn.skyprospringhw.cursework2.exceptions.MathQuestionException;
import com.heimtn.skyprospringhw.cursework2.objects.Question;
import com.heimtn.skyprospringhw.cursework2.repo.QuestionRepository;
import com.heimtn.skyprospringhw.cursework2.services.JavaQuestionService;
import com.heimtn.skyprospringhw.cursework2.services.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;
    private QuestionService questionService;

    @BeforeEach
    public void startUp(){
        Collection<Question> expected = new HashSet<>();
        expected.add(new Question("QText", "AText"));
        expected.add(new Question("QText1", "AText1"));

        Mockito.lenient().when(questionRepository.getAll()).thenReturn(expected);
        Mockito.lenient().when(questionRepository.add("QText3", "AText3")).thenReturn(new Question("QText3", "AText3"));
        Mockito.lenient().when(questionRepository.add(new Question("QText2", "AText2"))).thenReturn(new Question("QText2", "AText2"));
        Mockito.lenient().when(questionRepository.remove(new Question("QText1", "AText1"))).thenReturn(new Question("QText1", "AText1"));
        Mockito.lenient().when(questionRepository.add(new Question("QText", "AText"))).thenThrow(new JavaQuestionException("Такой вопрос уже есть в базе"));
        Mockito.lenient().when(questionRepository.add(null)).thenThrow(new JavaQuestionException("Вопрос не должен быть null"));
        Mockito.lenient().when(questionRepository.add(null, "AText")).thenThrow(new JavaQuestionException("Вопрос или ответ не должны быть null"));
        Mockito.lenient().when(questionRepository.add("QText",null)).thenThrow(new JavaQuestionException("Вопрос или ответ не должны быть null"));
        Mockito.lenient().when(questionRepository.remove(new Question("QText4", "AText4"))).thenThrow(new JavaQuestionException("Такого вопроса нет в базе"));

        questionService = new JavaQuestionService(questionRepository);
    }

    @Test
    public void add(){
        Question temp = new Question("QText2", "AText2");
        Question temp1 = new Question("QText3", "AText3");

        Assertions.assertEquals(temp, questionService.add(temp));
        Assertions.assertEquals(temp1, questionService.add("QText3", "AText3"));
    }

    @Test
    public void addNegative(){
        Question temp = new Question("QText", "AText");

        JavaQuestionException thrown = Assertions.assertThrows(JavaQuestionException.class,
                () -> questionService.add(temp));
        Assertions.assertEquals("Такой вопрос уже есть в базе", thrown.getMessage());
        JavaQuestionException thrown1 = Assertions.assertThrows(JavaQuestionException.class,
                () -> questionService.add(null));
        Assertions.assertEquals("Вопрос не должен быть null", thrown1.getMessage());

        JavaQuestionException thrown2 = Assertions.assertThrows(JavaQuestionException.class,
                () -> questionService.add(null, "AText"));
        Assertions.assertEquals("Вопрос или ответ не должны быть null", thrown2.getMessage());
        JavaQuestionException thrown3 = Assertions.assertThrows(JavaQuestionException.class,
                () -> questionService.add("QText",null));
        Assertions.assertEquals("Вопрос или ответ не должны быть null", thrown3.getMessage());
    }

    @Test
    public void getAll(){

        Collection<Question> actual = questionService.getAll();

        Assertions.assertTrue(actual.contains(new Question("QText", "AText")));
        Assertions.assertTrue(actual.contains(new Question("QText1", "AText1")));

    }

    @Test
    public void remove(){
        Assertions.assertEquals(new Question("QText1", "AText1"), questionService.remove(new Question("QText1", "AText1")));
    }

    @Test
    public void removeNegative(){
        JavaQuestionException thrown = Assertions.assertThrows(JavaQuestionException.class,
                () -> questionService.remove(new Question("QText4", "AText4")));
        Assertions.assertEquals("Такого вопроса нет в базе", thrown.getMessage());
    }
}

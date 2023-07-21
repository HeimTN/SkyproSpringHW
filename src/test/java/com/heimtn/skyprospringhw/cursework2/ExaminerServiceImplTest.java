package com.heimtn.skyprospringhw.cursework2;

import com.heimtn.skyprospringhw.cursework2.exceptions.LargeQuantityRequestException;
import com.heimtn.skyprospringhw.cursework2.objects.Question;
import com.heimtn.skyprospringhw.cursework2.services.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService questionService1;
    @Mock
    private MathQuestionService questionService2;


    private ExaminerService examinerService;

    @BeforeEach
    public void startUp(){
        Collection<Question> expected = new HashSet<>();
        Collection<Question> expected2 = new HashSet<>();
        expected.add(new Question("QText", "AText"));
        expected.add(new Question("QText1", "AText1"));
        expected2.add(new Question("QText2", "AText2"));
        expected2.add(new Question("QText3", "AText3"));
        expected2.add(new Question("QText4", "AText4"));

        Mockito.when(questionService1.getAll()).thenReturn(expected);
        Mockito.when(questionService2.getAll()).thenReturn(expected2);

        examinerService = new ExaminerServiceImpl(questionService1, questionService2);
    }

    @Test
    public void getQuestions(){
        Collection<Question> actual = examinerService.getQuestions(5);
        Assertions.assertTrue(actual.contains(new Question("QText", "AText")));
        Assertions.assertTrue(actual.contains(new Question("QText1", "AText1")));
        Assertions.assertTrue(actual.contains(new Question("QText2", "AText2")));
        Assertions.assertTrue(actual.contains(new Question("QText3", "AText3")));
        Assertions.assertTrue(actual.contains(new Question("QText4", "AText4")));
    }

    @Test
    public void getQuestionsNegative(){
        LargeQuantityRequestException thrown = Assertions.assertThrows(LargeQuantityRequestException.class,
                () -> examinerService.getQuestions(40));
        Assertions.assertEquals("Такого количества вопросов нет", thrown.getMessage());
    }
}

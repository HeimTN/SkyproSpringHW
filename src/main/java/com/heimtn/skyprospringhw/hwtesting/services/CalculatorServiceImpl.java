package com.heimtn.skyprospringhw.hwtesting.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int plus(int num1, int num2){
        return num1 + num2;
    }

    @Override
    public int multiply(int num1, int num2){
        return num1*num2;
    }

    @Override
    public int minus(int num1, int num2){
        return num1-num2;
    }

    @Override
    public float divide(int num1, int num2){
        if(num2 != 0) {
            return (float)num1/ (float)num2;
        }
        else throw new IllegalArgumentException("На ноль делить нельзя");
    }
}

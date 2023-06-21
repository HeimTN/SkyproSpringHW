package com.heimtn.skyprospringhw;

import com.heimtn.skyprospringhw.hwtesting.services.CalculatorService;
import com.heimtn.skyprospringhw.hwtesting.services.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceImplTest {

    private final CalculatorService service = new CalculatorServiceImpl();


    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void checkCalculator(int num1, int num2, int expectedResultPlus, int expectedResultMultiply,
                                int expectedResultMinus, double expectedResultDivide){
        int actualResultPlus = service.plus(num1, num2);
        int actualResultMultiply = service.multiply(num1, num2);
        int actualResultMinus = service.minus(num1, num2);
        double actualResultDivide = service.divide(num1, num2);

        Assertions.assertEquals(expectedResultPlus, actualResultPlus);
        Assertions.assertEquals(expectedResultMultiply, actualResultMultiply);
        Assertions.assertEquals(expectedResultMinus, actualResultMinus);
        Assertions.assertEquals(expectedResultDivide,actualResultDivide);

    }

   @Test
    public void checkDivideForZeroParam(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.divide(3,0));
        Assertions.assertEquals("На ноль делить нельзя", thrown.getMessage());
    }



    public static Stream<Arguments> provideParamsForTest(){
        return Stream.of(
                Arguments.of(5, 5, 10, 25, 0, 1),
                Arguments.of( 2, 4, 6, 8, -2, 0.5),
                Arguments.of(0, 6, 6, 0, -6, 0)
        );
    }
}

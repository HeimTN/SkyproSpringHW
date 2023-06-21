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
    private final int number1 = 2;
    private final int number2 = 5;
    private final int number3 = 21;
    private final int number4 = 385;
    
    
    @Test
    public void plus(){
        int actualResult1 = service.plus(number1, number2);
        int actualResult2 = service.plus(number3, number4);
        int actualResult3 = service.plus(number1, number3);
        int actualResult4 = service.plus(number2, number4);
        
        int exceptedResult1 = number1 + number2;
        int exceptedResult2 = number3 + number4;
        int exceptedResult3 = number1 + number3;
        int exceptedResult4 = number2 + number4;

        Assertions.assertEquals(exceptedResult1, actualResult1);
        Assertions.assertEquals(exceptedResult2, actualResult2);
        Assertions.assertEquals(exceptedResult3, actualResult3);
        Assertions.assertEquals(exceptedResult4, actualResult4);
    }

    @Test
    public void multiply(){
        int actualResult1 = service.multiply(number1, number2);
        int actualResult2 = service.multiply(number3, number4);
        int actualResult3 = service.multiply(number1, number3);
        int actualResult4 = service.multiply(number2, number4);

        int exceptedResult1 = number1 * number2;
        int exceptedResult2 = number3 * number4;
        int exceptedResult3 = number1 * number3;
        int exceptedResult4 = number2 * number4;

        Assertions.assertEquals(exceptedResult1, actualResult1);
        Assertions.assertEquals(exceptedResult2, actualResult2);
        Assertions.assertEquals(exceptedResult3, actualResult3);
        Assertions.assertEquals(exceptedResult4, actualResult4);
    }

    @Test
    public void minus(){
        int actualResult1 = service.minus(number1, number2);
        int actualResult2 = service.minus(number3, number4);
        int actualResult3 = service.minus(number1, number3);
        int actualResult4 = service.minus(number2, number4);

        int exceptedResult1 = number1 - number2;
        int exceptedResult2 = number3 - number4;
        int exceptedResult3 = number1 - number3;
        int exceptedResult4 = number2 - number4;

        Assertions.assertEquals(exceptedResult1, actualResult1);
        Assertions.assertEquals(exceptedResult2, actualResult2);
        Assertions.assertEquals(exceptedResult3, actualResult3);
        Assertions.assertEquals(exceptedResult4, actualResult4);
    }

    @Test
    public void divide(){
        float actualResult1 = service.divide(number1, number2);
        float actualResult2 = service.divide(number3, number4);
        float actualResult3 = service.divide(number1, number3);
        float actualResult4 = service.divide(number2, number4);

        float exceptedResult1 = (float) number1 / number2;
        float exceptedResult2 = (float) number3 / number4;
        float exceptedResult3 = (float) number1 / number3;
        float exceptedResult4 = (float) number2 / number4;

        Assertions.assertEquals(exceptedResult1, actualResult1);
        Assertions.assertEquals(exceptedResult2, actualResult2);
        Assertions.assertEquals(exceptedResult3, actualResult3);
        Assertions.assertEquals(exceptedResult4, actualResult4);
    }
    
    
    
    
    
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

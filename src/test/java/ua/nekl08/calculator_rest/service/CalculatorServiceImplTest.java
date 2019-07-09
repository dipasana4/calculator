package ua.nekl08.calculator_rest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.nekl08.calculator_rest.CalculatorRestApplication;
import ua.nekl08.calculator_rest.model.Elements;
import ua.nekl08.calculator_rest.model.Result;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorRestApplication.class)
public class CalculatorServiceImplTest {

    @Autowired
    CalculatorService calculatorService;

    @Test
    public void plus() {
        Result result = calculatorService.plus(new Elements(1l, 2l));
        assertEquals(new Result(3l), result);
    }

    @Test
    public void minus() {
        Result result = calculatorService.minus(new Elements(4l, 1l));
        assertEquals(new Result(3l), result);
    }

    @Test
    public void multiply() {
        Result result = calculatorService.multiply(new Elements(3l, 2l));
        assertEquals(new Result(6l), result);

    }

    @Test
    public void divide() {
        Result result = calculatorService.divide(new Elements(1l, 2l));
        assertEquals(new Result(0l), result);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        Result result = calculatorService.divide(new Elements(1l, 0l));

    }
}
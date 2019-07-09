package ua.nekl08.calculator_rest.service;

import org.springframework.stereotype.Service;
import ua.nekl08.calculator_rest.model.Elements;
import ua.nekl08.calculator_rest.model.Result;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Result plus(Elements elements) {
        return new Result(elements.getFirstElement() + elements.getSecondElement());
    }

    @Override
    public Result minus(Elements elements) {
        return new Result(elements.getFirstElement() - elements.getSecondElement());
    }

    @Override
    public Result multiply(Elements elements) {
        return new Result(elements.getFirstElement() * elements.getSecondElement());
    }

    @Override
    public Result divide(Elements elements) {
        return new Result(elements.getFirstElement() / elements.getSecondElement());
    }
}

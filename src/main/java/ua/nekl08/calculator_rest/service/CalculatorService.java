package ua.nekl08.calculator_rest.service;

import ua.nekl08.calculator_rest.model.Elements;
import ua.nekl08.calculator_rest.model.Result;

public interface CalculatorService {

    Result plus(Elements elements);

    Result minus(Elements elements);

    Result multiply(Elements elements);

    Result divide(Elements elements);
}

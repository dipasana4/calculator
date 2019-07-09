package ua.nekl08.calculator_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import ua.nekl08.calculator_rest.model.Elements;
import ua.nekl08.calculator_rest.model.Result;
import ua.nekl08.calculator_rest.service.CalculatorService;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestCalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/plus")
    public Result plus(@RequestBody Elements elements) throws Exception {
        return calculatorService.plus(elements);

    }

    @PostMapping("/minus")
    public Result minus(@RequestBody Elements elements) throws Exception {
        return calculatorService.minus(elements);

    }

    @PostMapping("/multiply")
    public Result multiply(@RequestBody Elements elements) throws Exception {
        return calculatorService.multiply(elements);

    }

    @PostMapping("/divide")
    public Result divide(@RequestBody Elements elements) throws Exception {
        return calculatorService.divide(elements);

    }



//    @ExceptionHandler(Exception.class)
//    private ResponseEntity<Object> exceptionHandler(Exception e) {
//        Map<String, String> responseBody = new HashMap<>();
//        if (e instanceof HttpMessageNotReadableException) {
//            responseBody.put("error", "Invalid value of " + (e.getMessage().contains("firstElement") ? "firstElement" : "secondElement"));
//        } else if (e instanceof ArithmeticException) {
//            responseBody.put("error", "Divide by zero");
//        } else if (e instanceof NullPointerException) {
//            responseBody.put("error", "Element not exist");
//        } else responseBody.put("error", e.getMessage());
//        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<Object> ex1(HttpMessageNotReadableException e) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("error", "Invalid value of " + (e.getMessage().contains("firstElement") ? "firstElement" : "secondElement"));
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArithmeticException.class)
    private ResponseEntity<Object> ex2(ArithmeticException e) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("error", "Divide by zero");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity<Object> ex3(NullPointerException e) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("error", "Element not exist");
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> ex4(Exception e) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("error", e.getMessage());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }
}

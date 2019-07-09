package ua.nekl08.calculator_rest.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ua.nekl08.calculator_rest.model.Elements;
import ua.nekl08.calculator_rest.model.Result;
import ua.nekl08.calculator_rest.service.CalculatorService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestCalculatorController.class)
public class RestCalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void plus() throws Exception {
        given(calculatorService.plus(new Elements(10l, 2l))).willReturn(new Result(12l));
        MvcResult mvcResult = mvc.perform(
                post("/api/plus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstElement\": 10, \"secondElement\": 2}"))
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertEquals("{\"result\":12}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void minus() throws Exception {
        given(calculatorService.minus(new Elements(10l, 2l))).willReturn(new Result(18l));
        MvcResult mvcResult = mvc.perform(
                post("/api/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstElement\": 10, \"secondElement\": 2}"))
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertEquals("{\"result\":18}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void multiply() throws Exception {
        given(calculatorService.multiply(new Elements(10l, 2l))).willReturn(new Result(20l));
        MvcResult mvcResult = mvc.perform(
                post("/api/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstElement\": 10, \"secondElement\": 2}"))
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertEquals("{\"result\":20}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void divide() throws Exception {
        given(calculatorService.divide(new Elements(10l, 2l))).willReturn(new Result(5l));
        MvcResult mvcResult = mvc.perform(
                post("/api/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstElement\": 10, \"secondElement\": 2}"))
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertEquals("{\"result\":5}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void invalidValue() throws Exception {
        MvcResult mvcResult = mvc.perform(
                post("/api/plus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstElement\": \"a\", \"secondElement\": 2}"))
                .andExpect(status().isBadRequest())
                .andReturn();
        Assert.assertEquals("{\"error\":\"Invalid value of firstElement\"}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void divideByZero() throws Exception {
        given(calculatorService.divide(new Elements(10l, 0l))).willThrow(ArithmeticException.class);
        MvcResult mvcResult = mvc.perform(
                post("/api/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstElement\": 10, \"secondElement\": 0}"))
                .andExpect(status().isBadRequest())
                .andReturn();
        Assert.assertEquals("{\"error\":\"Divide by zero\"}", mvcResult.getResponse().getContentAsString());
    }
}
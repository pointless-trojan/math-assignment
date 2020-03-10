package com.akhi.math.mathassignment.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MathAssignmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testV1() throws Exception {
        mockMvc.perform(get("/v1.0/1/5"))
                .andDo(print()) //For Debugging in case of failures
                .andExpect(status().isOk())
                .andExpect(content().string("{\"series\":[\"1\",\"2\",\"Fizz\",\"4\",\"Buzz\"]}"));
    }

    @Test
    public void testV2() throws Exception {
        mockMvc.perform(get("/v2.0/47/55"))
                .andDo(print()) //For Debugging in case of failures
                .andExpect(status().isOk())
                .andExpect(content().string("{\"series\":[\"47\",\"Fizz\",\"49\",\"Buzz\",\"FizzBuzz\",\"Buzz\",\"FizzBuzz\",\"FizzBuzz\",\"Buzz\"]}"));
    }

}

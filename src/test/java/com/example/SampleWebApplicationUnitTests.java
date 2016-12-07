package com.example;


import com.example.controller.EmployeeController;
import com.example.domain.Employee;
import com.example.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SampleWebApplicationUnitTests {

    private MockMvc mvc;

    @InjectMocks
    private EmployeeController controller;

    @Mock
    private EmployeeService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllEmployeeShouldFoundOneRecord() throws Exception {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("john");
        employee.setLastName("deo");

        Mockito.when(service.findEmployees()).thenReturn(Arrays.asList(employee));

        this.mvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is(1)));
    }

}
package com.example;


import com.example.controller.EmployeeController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SampleWebApplicationUnitTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;
//
//    @InjectMocks
//    lateinit var controller: NewsController
//    @Mock lateinit var newsService: NewsService
//    @Mock lateinit var viewNewsRepository: ViewNewsRepository
//    lateinit var mvc: MockMvc
//
//    @Before
//    fun setup() {
//        mvc = MockMvcBuilders.standaloneSetup(controller).build()
//    }

    @InjectMocks
    private EmployeeController controller;



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHome() throws Exception {
        this.mvc.perform(get("/employees")).andExpect(status().isOk());
    }

}
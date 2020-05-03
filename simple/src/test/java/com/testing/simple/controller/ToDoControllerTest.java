package com.testing.simple.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.testing.simple.SimpleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ToDoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void verifyAllToDoList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/todo/").accept(MediaType.ALL.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1))).andDo(print());
    }

    @Test
    public void verifyToDoById() throws  Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todo/find/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.text").exists())
                .andExpect(jsonPath("$.completed").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.completed").value(true))
                .andDo(print());
    }

    @Test
    public void verifyDeleteById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/todo/delete/2"))
                .andDo(print());
    }


}

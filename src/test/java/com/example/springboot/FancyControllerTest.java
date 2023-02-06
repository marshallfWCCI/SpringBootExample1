package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class FancyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void greetsByName() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "12345"))
                .andExpect(content().string(containsString("Hello, 12345")));
    }
}
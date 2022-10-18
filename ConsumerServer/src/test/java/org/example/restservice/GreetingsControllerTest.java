package org.example.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGreetingsControllerGetRequestWithDefaultMessage_thenReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void whenGreetingsControllerGetRequestWithRequestParam_thenReturnCorrectMessage() throws Exception {
        this.mockMvc.perform(get("/greeting").param("name", "Mike")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mike")));
    }

    @Test
    public void whenGreetingsControllerPostRequestWithRequestParam_thenReturnCorrectMessage() throws Exception {
        var values = new HashMap<String, String>() {{
            put("name", "John Doe");
        }};
        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(values);

        this.mockMvc.perform(post("/users")
                        .contentType(APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"content\":\"John Doe\"}")));
    }
}
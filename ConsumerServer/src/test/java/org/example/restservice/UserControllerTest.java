package org.example.restservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import org.example.consumer.DemoApplication;
import org.example.consumer.domain.UserDomain;
import org.example.consumer.repository.UserRepository;
import org.example.consumer.restservice.UserController;
import org.example.consumer.service.impl.UserFacadeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = DemoApplication.class)
class UserControllerTest {
    @MockBean
    UserFacadeService userFacadeService;
    @MockBean
    UserRepository dataSource;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGreetingsControllerGetRequestWithDefaultMessage_thenReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().is(200))
                .andExpect(content().string(containsString("Bad request param")));
    }

    @Test
    public void whenGreetingsControllerGetRequestWithRequestParam_thenReturnCorrectMessage() throws Exception {
        UserDomain userDomain = createUserDomain(1L);
        Mockito.when(userFacadeService.getUserById(1L)).thenReturn(Optional.of(userDomain));
        this.mockMvc.perform(get("/users").param("id", "1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(userDomain.toString())));
    }

    @Test
    public void whenGreetingsControllerPostRequestWithRequestParam_thenReturnCorrectMessage() throws Exception {
        UserDomain userDomain = createUserDomain(2);
        String requestBody = mapUserDomainToJson(userDomain);
        Mockito.when(userFacadeService.saveUser(Mockito.any())).thenReturn(userDomain);
        byte[] contentAsByteArray = this.mockMvc.perform(post("/users")
                        .contentType(APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print()).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsByteArray();
        UserDomain actualUser = jsonToUser(contentAsByteArray);
        Assertions.assertEquals(userDomain,actualUser);
    }

    private UserDomain jsonToUser(byte[] contentAsByteArray) throws JsonProcessingException {
        String content = new String(contentAsByteArray);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, UserDomain.class);
    }

    private static String getRandomString() {
        return UUID.randomUUID().toString();
    }

    private UserDomain createUserDomain(long id) {
        return new UserDomain(id, getRandomString(), getRandomString(), getRandomString(), getRandomString());
    }
    @SneakyThrows
    public String mapUserDomainToJson(UserDomain user) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(user);
    }
}
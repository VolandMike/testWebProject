package org.example.consumer.restservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.consumer.domain.Greetings;
import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.example.consumer.service.UserFacadeService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GreetingsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final UserFacadeService facadeService;

    @GetMapping("/greeting")
    public Greetings greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info("I get query with parameter {}", name);
        return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Greetings saveUser(@RequestBody UserDTO userDTO) {
        log.info("Request body {}", userDTO);
        UserDomain userDomain = facadeService.saveUser(userDTO);
        log.info("Save user {}", userDomain);
        return new Greetings(counter.incrementAndGet(), userDTO.getFirstname());
    }
}

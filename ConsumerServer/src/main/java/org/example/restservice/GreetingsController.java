package org.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.example.dto.Greetings;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greetings greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Greetings saveUser(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("Save user with name " + name);
        return new Greetings(counter.incrementAndGet(), name);
    }
}

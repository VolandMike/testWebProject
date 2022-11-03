package org.example.consumer.restservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.consumer.domain.UserDomain;
import org.example.consumer.dto.UserDTO;
import org.example.consumer.service.UserFacade;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserFacade facadeService;

    @GetMapping("/users")
    public String greeting(@RequestParam(value = "id", defaultValue = "-1") Long id) {
        log.info("I get query with parameter {}", id);
        if (id < 0) {
            return "Bad request param";
        }
        Optional<UserDomain> userDomain = facadeService.getUserById(id);
        if (userDomain.isPresent()) {
            return userDomain.get().toString();
        }
        return String.format("Can't find user with id %s", id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public UserDomain saveUser(@RequestBody UserDTO userDTO) {
        log.info("Request body {}", userDTO);
        UserDomain userDomain = facadeService.saveUser(userDTO);
        log.info("Save user {}", userDomain);
        return userDomain;
    }
}

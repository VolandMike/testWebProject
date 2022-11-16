package com.example.producerclient.contoller;

import com.example.producerclient.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final ApplicationEventPublisher eventPublisher;

    @GetMapping("/registration_form")
    public String showRegistrationForm(Model model) {
        User employee = new User();
        model.addAttribute("user", employee);
        return "registration_form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "display_form";
    }

    @PostMapping("/send")
    public String sendEmployee(@ModelAttribute User user) {
        eventPublisher.publishEvent(user);
        return "registration_form";
    }
}

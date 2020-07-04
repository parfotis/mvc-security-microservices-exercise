package com.learning.ote.spring.mvc.controller;

import com.learning.ote.spring.mvc.service.GreetingService;
import com.learning.ote.spring.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Autowired
    private HelloService service;

    @Autowired
    @Qualifier("greetingServiceGr")
    private GreetingService greetingService;

    @GetMapping("/")
    public String sayHello(Model model) {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        String username = service.getUsernameFromId(id);

        model.addAttribute("username", username);

        String greeting = greetingService.getGreeting();
        model.addAttribute("greeting", greeting);
        return "hello";
    }

}

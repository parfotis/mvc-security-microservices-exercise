package com.learning.ote.spring.mvc.controller;

import com.learning.ote.spring.mvc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UsersService usersService;

    @GetMapping({"/"})
    public String home(Model model) {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        String username = usersService.getUsernameFromId(id);
        model.addAttribute("username", username);
        return "/index";
    }
}

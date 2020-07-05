package com.learning.ote.spring.mvc.controller;

import com.learning.ote.spring.mvc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private UsersService usersService;

    @ModelAttribute
    public void securityContext(Model model) {
        List<String> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        model.addAttribute("_authorities", authorities);
    }

    @GetMapping({"/"})
    public String home(Model model) {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        String username = usersService.getUsernameFromId(id);
        model.addAttribute("username", username);
        return "/index";
    }
}

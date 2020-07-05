package com.learning.ote.spring.mvc.controller;

import com.learning.ote.spring.mvc.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("admin/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    @RolesAllowed("ROLE_ADMIN")
    public String getAllUsers(Model model) {
        model.addAttribute("users", usersService.getUsers());
        return "users";
    }
}

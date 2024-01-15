package com.razahy.razahyeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class AccountController {
    private static final String LOGIN_ERROR = "Bad credentials";

    @GetMapping("/login")
    public String getLogin(Model model, Optional<String> error) {
        if (error.isPresent()) {
            model.addAttribute("error", LOGIN_ERROR);
        }
        return "login";
    }
}

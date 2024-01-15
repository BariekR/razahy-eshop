package com.razahy.razahyeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class AccountController {
    private static final String LOGIN_ERROR = "Bad credentials";
    private static final String LOGIN_HEADER = "Log in";
    private static final String LOGIN_BUTTON = "Sign in";
    private static final String LOGIN_ENDPOINT = "/login";
    private static final String LOGIN_FOOTER_TEXT = "Need an account? Register";
    private static final String REGISTER_HEADER = "Create a new account";
    private static final String REGISTER_BUTTON = "Register";
    private static final String REGISTER_ENDPOINT = "/register";
    private static final String REGISTER_FOOTER_TEXT = "Already have an account? Log in";

    @GetMapping(LOGIN_ENDPOINT)
    public String getLogin(Model model, Optional<String> error) {
        if (error.isPresent()) {
            model.addAttribute("error", LOGIN_ERROR);
        }
        model.addAttribute("loginHeader", LOGIN_HEADER);
        model.addAttribute("loginButton", LOGIN_BUTTON);
        model.addAttribute("loginFooterAnchor", REGISTER_ENDPOINT);
        model.addAttribute("loginFooterAnchorText", LOGIN_FOOTER_TEXT);
        return "login";
    }

    @GetMapping(REGISTER_ENDPOINT)
    public String getRegister(Model model, Optional<String> error) {
        model.addAttribute("loginHeader", REGISTER_HEADER);
        model.addAttribute("loginButton", REGISTER_BUTTON);
        model.addAttribute("loginFooterAnchor", LOGIN_ENDPOINT);
        model.addAttribute("loginFooterAnchorText", REGISTER_FOOTER_TEXT);
        return "login";
    }
}

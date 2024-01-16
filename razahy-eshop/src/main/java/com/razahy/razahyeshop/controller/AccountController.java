package com.razahy.razahyeshop.controller;

import com.razahy.razahyeshop.exception.CustomerAlreadyExistException;
import com.razahy.razahyeshop.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private static final String REGISTER_INVALID_EMAIL = "Please provide a valid email address";
    private static final String REGISTER_INVALID_PASSWORD = "Please provide password between 8 and 30 characters";
    private static final String REGISTER_EMAIL_ALREADY_EXISTS = "An account with this email already exists";
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String getLogin(Model model, Optional<String> error) {
        if (error.isPresent()) {
            model.addAttribute("error", LOGIN_ERROR);
        }
        model.addAttribute("loginHeader", LOGIN_HEADER);
        model.addAttribute("loginButton", LOGIN_BUTTON);
        model.addAttribute("loginFooterAnchor", REGISTER_ENDPOINT);
        model.addAttribute("loginFooterAnchorText", LOGIN_FOOTER_TEXT);
        model.addAttribute("loginProcessUrl", LOGIN_ENDPOINT);
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model, Optional<String> error) {
        model.addAttribute("loginHeader", REGISTER_HEADER);
        model.addAttribute("loginButton", REGISTER_BUTTON);
        model.addAttribute("loginFooterAnchor", LOGIN_ENDPOINT);
        model.addAttribute("loginFooterAnchorText", REGISTER_FOOTER_TEXT);
        model.addAttribute("loginProcessUrl", REGISTER_ENDPOINT);
        return "login";
    }

    @PostMapping("/register")
    public String postRegister(RedirectAttributes ra, String username, String password) {
        boolean emailFormatIsValid = accountService.isEmailFormatValid(username);
        boolean passwordFormatIsValid = accountService.isPasswordFormatValid(password);

        if (!emailFormatIsValid) {
            ra.addFlashAttribute("emailNotValidError", REGISTER_INVALID_EMAIL);
        }
        if (!passwordFormatIsValid) {
            ra.addFlashAttribute("passwordNotValidError", REGISTER_INVALID_PASSWORD);
        }
        if (!emailFormatIsValid || !passwordFormatIsValid) {
            ra.addFlashAttribute("username", username);
            return "redirect:/register";
        }

        try {
            accountService.createCustomer(username, password);
        } catch (CustomerAlreadyExistException e) {
            ra.addFlashAttribute("customerAlreadyExistsError", REGISTER_EMAIL_ALREADY_EXISTS);
            return "redirect:/register";
        }

        return "redirect:/login";
    }
}

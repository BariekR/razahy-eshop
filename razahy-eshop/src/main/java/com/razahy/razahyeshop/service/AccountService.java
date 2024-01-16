package com.razahy.razahyeshop.service;

import com.razahy.razahyeshop.exception.CustomerAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    boolean isEmailFormatValid(String email);
    boolean isPasswordFormatValid(String rawPassword);
    void createCustomer(String email, String rawPassword) throws CustomerAlreadyExistException;
}

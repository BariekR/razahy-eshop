package com.razahy.razahyeshop.service;

import com.razahy.razahyeshop.exception.CustomerAlreadyExistException;
import com.razahy.razahyeshop.model.Customer;
import com.razahy.razahyeshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceDb implements AccountService {
    private CustomerRepository customerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean isEmailFormatValid(String email) {
        return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") && email.length() <= 255;
    }

    @Override
    public boolean isPasswordFormatValid(String rawPassword) {
        return !(rawPassword.length() < 8 || rawPassword.length() > 30);
    }

    @Override
    public void createCustomer(String email, String rawPassword) throws CustomerAlreadyExistException {
        if (customerRepository.findCustomerByEmail(email).isPresent()) {
            throw new CustomerAlreadyExistException("Customer already exists");
        }
        String hashedPassword = bCryptPasswordEncoder.encode(rawPassword);
        Customer customer = new Customer(email, hashedPassword, "user");

        customerRepository.save(customer);
    }
}

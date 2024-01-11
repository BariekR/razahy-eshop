package com.razahy.razahyeshop.security;

import com.razahy.razahyeshop.model.Customer;
import com.razahy.razahyeshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@AllArgsConstructor
public class CustomerDetailsService implements UserDetailsService {
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> optCustomer = customerRepository.findCustomerByEmail(username);
        if (optCustomer.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new CustomerDetails(optCustomer.get());
    }
}

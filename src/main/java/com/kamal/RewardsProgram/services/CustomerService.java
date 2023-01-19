package com.kamal.RewardsProgram.services;

import com.kamal.RewardsProgram.entities.Customer;
import com.kamal.RewardsProgram.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }
}

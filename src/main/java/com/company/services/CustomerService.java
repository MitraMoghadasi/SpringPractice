package com.company.services;

import com.company.models.CustomerEntity;
import com.company.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public CustomerEntity getId(Integer id) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(id);
        return customerEntityOptional.get();
    }

    public void saveCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
    }
}

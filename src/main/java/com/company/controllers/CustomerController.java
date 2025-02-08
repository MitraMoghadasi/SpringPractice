package com.company.controllers;

import com.company.models.CustomerEntity;
import com.company.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public void saveCustomer(@RequestBody CustomerEntity customer) {
        customerService.saveCustomer(customer);
    }

    @GetMapping
    public CustomerEntity getCustomerById(Integer id) {
        return customerService.getId(id);
    }
}

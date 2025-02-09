package com.company.controllers;

import com.company.models.entity.CustomerEntity;
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

    @GetMapping("/{id}")
    public CustomerEntity getCustomerById(@PathVariable Integer id) {
        return customerService.getId(id);
    }

    @PutMapping("/{id}")
    public void putCustomer(@RequestBody CustomerEntity customer, @PathVariable Integer id) {
        customerService.putCustomer(customer , id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }
}

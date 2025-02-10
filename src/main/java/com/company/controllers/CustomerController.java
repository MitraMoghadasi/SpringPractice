package com.company.controllers;

import com.company.models.dto.CreateOrUpdateCustomerDto;
import com.company.models.dto.GetCustomerDto;
import com.company.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public void saveCustomer(@RequestBody CreateOrUpdateCustomerDto customer) {
        customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public GetCustomerDto getCustomerById(@PathVariable Integer id) {
        return customerService.getId(id);
    }

    @PutMapping("/{id}")
    public void putCustomer(@RequestBody CreateOrUpdateCustomerDto customer, @PathVariable Integer id) {
        customerService.putCustomer(customer , id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }
}

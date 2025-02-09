package com.company.services;

import com.company.models.entity.CustomerEntity;
import com.company.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public CustomerEntity getId(Integer id) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(id);// output of findById(id) is optional type
        return customerEntityOptional.get();
    }

    public void saveCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
    }

    public void putCustomer(CustomerEntity customer, Integer id) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(id);
        if(customerEntityOptional.isPresent()) {
//            customer.setId(id);
//            customerRepository.save(customer);
//            or
            CustomerEntity old = customerEntityOptional.get();
            old.setName(customer.getName());
            old.setGender(customer.getGender());
            old.setMobile(customer.getMobile());
            customerRepository.save(old);
        }
    }

    public void deleteCustomer(Integer id) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(id);
        if(customerEntityOptional.isPresent()) {
            customerRepository.delete(customerEntityOptional.get());
        }

        /*
        Tozihe Optional
        Optional<CustomerEntity> optional = customerRepository.findById(100000);
        if (optional.isPresent()) {
            Gender g = optional.get().getGender();
        }
         */

        }


}

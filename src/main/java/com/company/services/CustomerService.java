package com.company.services;

import com.company.models.dto.CreateOrUpdateCustomerDto;
import com.company.models.dto.GetCustomerDto;
import com.company.models.entity.CustomerEntity;
import com.company.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public GetCustomerDto getId(Integer id) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(id);// output of findById(id) is optional type
        CustomerEntity customerEntity = customerEntityOptional.get();
        GetCustomerDto customerDto = new GetCustomerDto();
        customerDto.setId(customerEntity.getId());
        customerDto.setName(customerEntity.getName());
        customerDto.setGender(customerEntity.getGender());

        return customerDto;
    }

    public void saveCustomer(CreateOrUpdateCustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDto.getName());
        customerEntity.setMobile(customerDto.getMobile());
        customerEntity.setGender(customerDto.getGender());
        customerRepository.save(customerEntity);
    }

    public void putCustomer(CreateOrUpdateCustomerDto customerDto, Integer id) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(id);
        if(customerEntityOptional.isPresent()) {
//            customer.setId(id); this two lines are for before DTO
//            customerRepository.save(customer);
            CustomerEntity customerEntity = customerEntityOptional.get();
            customerEntity.setName(customerDto.getName());
            customerEntity.setGender(customerDto.getGender());
            customerEntity.setMobile(customerDto.getMobile());
            customerRepository.save(customerEntity);
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

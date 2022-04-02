package com.example.customerservice.service;


import com.example.customerservice.entity.Customer;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.request.CreateCustomerRequest;
import com.example.customerservice.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {

        Customer customer = new Customer();
        customer.setFirstName(createCustomerRequest.getFirstName());
        customer.setLastName(createCustomerRequest.getLastName());
        customer.setEmail(createCustomerRequest.getEmail());
        customer = customerRepository.save(customer);

        CustomerResponse customerResponse = new CustomerResponse(customer);


        return customerResponse;
    }

    public CustomerResponse getById (long id) {
        Customer customer = customerRepository.findById(id).get();
        CustomerResponse customerResponse = new CustomerResponse(customer);
        return customerResponse;
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream().map(customer -> {
            return new CustomerResponse(customer);
        }).collect(Collectors.toList());
    }

}

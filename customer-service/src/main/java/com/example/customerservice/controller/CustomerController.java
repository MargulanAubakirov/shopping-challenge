package com.example.customerservice.controller;


import com.example.customerservice.request.CreateCustomerRequest;
import com.example.customerservice.response.CustomerResponse;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.createCustomer(createCustomerRequest);
    }
    @GetMapping("/getById/{id}")
    public CustomerResponse getById (@PathVariable long id) {
        return customerService.getById(id);
    }
    @GetMapping("/all")
    public List<CustomerResponse> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}

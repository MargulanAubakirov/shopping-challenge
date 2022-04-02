package com.example.customerconsolidinfo.controller;

import com.example.customerconsolidinfo.Service.CustomerInfoService;
import com.example.customerconsolidinfo.models.Customer;
import com.example.customerconsolidinfo.models.CustomerInfo;
import com.example.customerconsolidinfo.request.CreateAddressRequest;
import com.example.customerconsolidinfo.request.CreateCustomerRequest;
import com.example.customerconsolidinfo.response.AddressResponse;
import com.example.customerconsolidinfo.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/customerinfo")
public class CustomerInfoController {

    @Autowired
    private CustomerInfoService customerInfoService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @GetMapping("/customers")
    public List<CustomerResponse> getAllCustomers(){
        return customerInfoService.getAllCustomers();
    }

    @PostMapping("/add")
    public String createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerInfoService.addCustomer(createCustomerRequest);
    }
    @GetMapping("/customer-rest-template/{id}")
    public String getCustomerById(@PathVariable ("id") Long id){
        return customerInfoService.getCustomerById(id);
    }


    @GetMapping("/addresses")
    public String getAllAddresses(){
        return customerInfoService.getAllAdresses();
    }

    @PostMapping("/addAddress")
    public String createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        return customerInfoService.addAddress(createAddressRequest);
    }
    @GetMapping("/address/{id}")
    public String getAddressById(@PathVariable ("id") Long id){
        return customerInfoService.getAddressById(id);
    }
    @GetMapping("/getCustomerById/{id}")
    public CustomerResponse getCustomerByIdViaWebClient(@PathVariable Long id){
        return customerInfoService.getCustomerByIdViaWebClient(id);
    }


}

package com.example.addressservice.controller;

import com.example.addressservice.model.Address;
import com.example.addressservice.request.CreateAddressRequest;
import com.example.addressservice.response.AddressResponse;
import com.example.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest){
        return addressService.createAddress(createAddressRequest);
    }
    @GetMapping("/{id}")
    public AddressResponse getById (@PathVariable long id) {
        return addressService.getById(id);
    }

    @GetMapping("/all")
    public List<AddressResponse> getAll(){
        return addressService.getAll();
    }

}


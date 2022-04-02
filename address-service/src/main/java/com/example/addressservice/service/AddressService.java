package com.example.addressservice.service;

import com.example.addressservice.model.Address;
import com.example.addressservice.repository.AddressRepository;
import com.example.addressservice.request.CreateAddressRequest;
import com.example.addressservice.response.AddressResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

@Data
public class AddressService{
    @Autowired
    private AddressRepository addressRepository;

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        Address address = new Address();
        address.setStreet(createAddressRequest.getStreet());
        address.setCity(createAddressRequest.getCity());
        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getById(long id) {
        Address address = addressRepository.findById(id).get();
        return new AddressResponse(address);
    }
    public List<AddressResponse> getAll(){
        return addressRepository.findAll().stream().map(address -> {
            return new AddressResponse(address);
        }).collect(Collectors.toList());
    }
}

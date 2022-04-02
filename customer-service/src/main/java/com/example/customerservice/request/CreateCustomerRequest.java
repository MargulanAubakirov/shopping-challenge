package com.example.customerservice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private long addressId;

}

package com.example.customerservice.response;

import com.example.customerservice.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private long id;

    private String firstName;

    private String lastName;

    private String email;


    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();

    }

}



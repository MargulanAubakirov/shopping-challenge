package com.example.customerconsolidinfo.response;

import com.example.customerconsolidinfo.models.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerResponse {
    private long id;

    private String firstName;

    private String lastName;

    private String email;


    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEMail();

    }

}



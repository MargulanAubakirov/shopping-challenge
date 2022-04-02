package com.example.customerconsolidinfo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerInfo {

    private String id;
    public String name;
    public String city;
}

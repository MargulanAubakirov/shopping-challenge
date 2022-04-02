package com.example.customerconsolidinfo.models;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@RequiredArgsConstructor

public class Address {

    private Long id;

    private String street;

    private String city;


}

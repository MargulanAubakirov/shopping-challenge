package com.example.addressservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@RequiredArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "City")
    private String city;


}

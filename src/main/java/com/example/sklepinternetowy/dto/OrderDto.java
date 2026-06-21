package com.example.sklepinternetowy.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private String firstName;
    private String lastName;
    private String email;
    private String zipCode;
    private String city;
}

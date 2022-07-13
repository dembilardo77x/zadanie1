package com.example.zadanie.contractor.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ContractorDto {

    private Long id;

    private String name;

    private String nip;

    private String address;

    private String postalCode;

    private String city;

    private String country;
}

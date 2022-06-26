package com.example.zadanie.contractor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Setter
@Getter
public class ContractorDto {

    private String name;

    private String nip;

    private String address;

    private String postalCode;

    private String city;

    private String country;


}

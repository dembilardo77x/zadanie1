package com.example.zadanie.contractor.model;

import com.example.zadanie.contractor.domain.Contractor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ContractorDtoMapper {
    public ContractorDto map(Contractor contractor) {
        ContractorDto dto = ContractorDto.builder()

                .id(contractor.getId()).name(contractor.getName()).address(contractor.getAddress()).city(contractor.getCity()).country(contractor.getCountry()).postalCode(contractor.getPostalCode()).nip(contractor.getNip()).build();

        return dto;
    }

    public Contractor map(ContractorDto dto) {

        Contractor contractor = Contractor.builder().name(dto.getName()).address(dto.getAddress()).city(dto.getCity()).country(dto.getCountry()).postalCode(dto.getPostalCode()).nip(dto.getNip()).versionDate(LocalDateTime.now()).creationDate(LocalDateTime.now()).build();
        return contractor;
    }
}
package com.example.zadanie.contractor.model;

import com.example.zadanie.contractor.ContractorController;
import com.example.zadanie.contractor.domain.Contractor;
import org.springframework.stereotype.Service;

@Service
public class ContractorDtoMapper {

    public ContractorDto map (Contractor contractor){
        ContractorDto dto = new ContractorDto();
        dto.setName(contractor.getName());
        dto.setNip(contractor.getNip());
        dto.setAddress(contractor.getAddress());
        dto.setPostalCode(contractor.getPostalCode());
        dto.setCity(contractor.getCity());
        dto.setCountry(contractor.getCountry());
        return dto;
    }
}

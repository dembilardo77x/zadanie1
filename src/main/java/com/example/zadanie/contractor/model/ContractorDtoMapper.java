package com.example.zadanie.contractor.model;

import com.example.zadanie.contractor.domain.Contractor;
import com.example.zadanie.contractor.domain.ContractorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ContractorDtoMapper {
    private final ContractorRepository contractorRepository;

    public ContractorDto toContractorDto(Contractor contractor) {
        return ContractorDto
                .builder()
                .id(contractor.getId())
                .name(contractor.getName())
                .address(contractor.getAddress())
                .city(contractor.getCity())
                .country(contractor.getCountry())
                .postalCode(contractor.getPostalCode())
                .nip(contractor.getNip())
                .build();
    }

    public final Contractor toCreateContractor(ContractorDto dto) {
        return Contractor
                .builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .city(dto.getCity())
                .country(dto.getCountry())
                .postalCode(dto.getPostalCode())
                .nip(dto.getNip())
                .versionDate(LocalDateTime.now())
                .creationDate(LocalDateTime.now())
                .build();
    }

    public final Contractor toUpdateContractor(ContractorDto dto) {
        Contractor contractor = contractorRepository.findById(dto.getId()).orElseThrow(
                () -> new EntityNotFoundException("Podany id nie istnieje"));
        return Contractor
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .city(dto.getCity())
                .country(dto.getCountry())
                .postalCode(dto.getPostalCode())
                .nip(dto.getNip())
                .versionDate(LocalDateTime.now())
                .creationDate(contractor.getCreationDate())
                .build();
    }
}
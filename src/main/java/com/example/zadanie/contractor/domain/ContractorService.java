package com.example.zadanie.contractor.domain;

import com.example.zadanie.contractor.model.ContractorDto;
import com.example.zadanie.contractor.model.ContractorDtoMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Builder
@Service
@RequiredArgsConstructor

public class ContractorService {
    private final ContractorRepository contractorRepository;
    private final ContractorDtoMapper contractorDtoMapper;


    public List<ContractorDto> findAll() {
        return contractorRepository.findAll().stream().map(contractorDtoMapper::map).collect(Collectors.toList());

    }

    public Optional<ContractorDto> findById(Long id) {
        return contractorRepository.findById(id).map(contractorDtoMapper::map);

    }

    public void deleteById(Long id) {

        contractorRepository.deleteById(id);
    }

    public ContractorDto create(ContractorDto contractorDto) {
        Contractor contractor = contractorDtoMapper.map(contractorDto);
        Contractor saveContractor = contractorRepository.save(contractor);
        return contractorDtoMapper.map(saveContractor);
    }

    public Optional<ContractorDto> update(Long id, ContractorDto contractorDto) {
        if (contractorRepository.existsById(id)) {
            Contractor contractor = contractorRepository.findById(id).get();
            Contractor updateContractor = contractorDtoMapper.map(contractorDto).toBuilder().creationDate(contractor.getCreationDate()).id(contractor.getId()).build();
            Contractor saveContractor = contractorRepository.save(updateContractor);
            ContractorDto mapContractorDto = contractorDtoMapper.map(saveContractor);
            return Optional.of(mapContractorDto);
        }
        return Optional.empty();
    }
}

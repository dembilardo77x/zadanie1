package com.example.zadanie.contractor.domain;

import com.example.zadanie.contractor.model.ContractorDto;
import com.example.zadanie.contractor.model.ContractorDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContractorService {
    private final ContractorRepository contractorRepository;
    private final ContractorDtoMapper contractorDtoMapper;

    public List<ContractorDto> findAll() {
        log.info("Wyszukano wszystkich użytkowników.");
        return contractorRepository.findAll().stream()
                .map(contractorDtoMapper::toContractorDto)
                .toList();
    }

    public Optional<ContractorDto> findById(final Long contractorId) {
        return contractorRepository.findById(contractorId).map(contractorDtoMapper::toContractorDto);
    }

    public void deleteById(final Long contractorId) {
        contractorRepository.deleteById(contractorId);
    }

    public ContractorDto create(final ContractorDto contractorDto) {
        log.info("Stworzono nowego użytkownika : NAZWA - {}, NIP - {}, ADRES - {}, KOD POCZTOWY - {},Miasto - {}, KRAJ - {}"
                ,contractorDto.getName(),contractorDto.getNip()
                ,contractorDto.getAddress(),contractorDto.getPostalCode(),contractorDto.getCity(),contractorDto.getCountry());
        return contractorDtoMapper.toContractorDto(contractorRepository.save(contractorDtoMapper.toCreateContractor(contractorDto)));
    }

    public Optional<ContractorDto> update(final Long contractorId,final ContractorDto contractorDto) {
        Contractor contractor = contractorRepository.findById(contractorId).orElseThrow(
                () -> new EntityNotFoundException("Podany id nie istnieje"));
        return Optional.of(contractorDtoMapper.toContractorDto(contractorRepository.save(contractorDtoMapper.toUpdateContractor(contractorDto))));
    }
}

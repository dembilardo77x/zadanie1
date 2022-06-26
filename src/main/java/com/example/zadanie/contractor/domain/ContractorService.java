package com.example.zadanie.contractor.domain;

import com.example.zadanie.contractor.model.ContractorDto;
import com.example.zadanie.contractor.model.ContractorDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ContractorService {
    private final ContractorRepository contractorRepository;
    private final ContractorDtoMapper contractorDtoMapper;

    public ContractorService(ContractorRepository contractorRepository, ContractorDtoMapper contractorDtoMapper) {
        this.contractorRepository = contractorRepository;
        this.contractorDtoMapper = contractorDtoMapper;
    }


    public List<ContractorDto> findAll() {
        return contractorRepository.findAll()
                .stream()
                .map(contractorDtoMapper::map)
                .collect(Collectors.toList());

    }

    public Optional<ContractorDto> findById(Long id) {
        return contractorRepository.findById(id)
                .map(contractorDtoMapper::map);

    }

    public void deleteById(Long id) {
        contractorRepository.deleteById(id);// przyjalem ze jak nie znajdziemy id to jakby byl usuniety
    }

    public Contractor create (Contractor con){
        Contractor contractor= new Contractor();
        contractor.setName(con.getName());
        contractor.setAddress(con.getAddress());
        contractor.setCity(con.getCity());
        contractor.setCountry(con.getCountry());
        contractor.setPostalCode(con.getPostalCode());
        contractor.setNip(con.getNip());
        contractor.setCreationDate(LocalDateTime.now());
        contractor.setVersionDate(LocalDateTime.now());
        return contractorRepository.save(contractor);
    }
    public Optional<Contractor> update (Long id ,Contractor con){ //aktualizacja calej encji
        Contractor contractor = contractorRepository.findById(id).get();

            contractor.setName(con.getName());
            contractor.setAddress(con.getAddress());
            contractor.setCity(con.getCity());
            contractor.setCountry(con.getCountry());
            contractor.setPostalCode(con.getPostalCode());
            contractor.setNip(con.getNip());
            contractor.setVersionDate(LocalDateTime.now());
        Contractor save = contractorRepository.save(contractor);
        return Optional.of(save);

        }
    }

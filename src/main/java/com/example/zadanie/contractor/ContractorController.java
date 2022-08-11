package com.example.zadanie.contractor;

import com.example.zadanie.contractor.domain.ContractorService;
import com.example.zadanie.contractor.model.ContractorDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/contractors")
public class ContractorController {

    private final ContractorService contractorService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(contractorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<ContractorDto> contractor = contractorService.findById(id);
        if (contractor.isPresent()) {
            log.info("Wyszukiwanie użytkownika o id = {}.", id);
            return ResponseEntity.ok(contractor.get());
        }
        log.warn("Użytkownik o id = {} nie istnieje", id);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable Long id) {
        contractorService.deleteById(id);
        log.info("Usunięto uzytkownika o id = {} lub użytkownik nie istnieje", id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ContractorDto contractorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contractorService.create(contractorDto));
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody ContractorDto contractorDto) {
        Optional<ContractorDto> findContractor = contractorService.findById(contractorDto.getId());
        if (findContractor.isPresent()) {
            log.info("Zaktualizowano użytkownika o id = {}", contractorDto.getId());
            return ResponseEntity.status(HttpStatus.OK).body(contractorService.update(contractorDto));
        }
        log.warn("Użytkownik o id = {} nie istnieje", contractorDto.getId());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

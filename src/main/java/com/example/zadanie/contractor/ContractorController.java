package com.example.zadanie.contractor;

import com.example.zadanie.contractor.domain.ContractorService;
import com.example.zadanie.contractor.model.ContractorDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            log.info("Wyszukiwanie użytkownika o id = {}.", id) ;
            return ResponseEntity.ok(contractor.get());
        }
        log.error("Użytkownik o id = " + id + " nie istnieje");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable Long id) {
        contractorService.deleteById(id);
        log.info("Usunięto uzytkownika o id = {} lub użytkownik nie istnieje",id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ContractorDto contractorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contractorService.create(contractorDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ContractorDto contractorDto) {
        Optional<ContractorDto> findContractor = contractorService.findById(id);
        if (findContractor.isPresent()) {
            log.info("Zaktualizowano użytkownika o id = {}",id);
            return ResponseEntity.status(HttpStatus.OK).body(contractorService.update(id, contractorDto));
        }
            log.error("Użytkownik o id = {} nie istnieje",id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

package com.example.zadanie.contractor;

import com.example.zadanie.contractor.domain.ContractorService;
import com.example.zadanie.contractor.model.ContractorDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/contractor")
public class ContractorController {

    private final ContractorService contractorService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ContractorDto> contractors = contractorService.findAll();
        log.info("Wyszukano wszystkich użytkowników.");
        return ResponseEntity.status(HttpStatus.OK).body(contractors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<ContractorDto> contractor = contractorService.findById(id);
        if (contractor.isPresent()) {
            log.info("Wyszukiwanie użytkownika o id = " + id);
            return ResponseEntity.ok(contractor.get());

        }
        log.error("Użytkownik o id = " + id + " nie istnieje");
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable Long id) {
        contractorService.deleteById(id);
        log.info("Usunięto uzytkownika o id = " + id + "lub użytkownik nie istnieje");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ContractorDto contractorDto) {
        ContractorDto createContractor = contractorService.create(contractorDto);

        log.info("Stworzono nowego użytkownika : NAZWA - " + contractorDto.getName() + " NIP - " + contractorDto.getNip() + " ADRES - " + contractorDto.getAddress() + " KOD POCZTOWY - " + contractorDto.getPostalCode() + " Miasto - " + contractorDto.getCity() + " KRAJ - " + contractorDto.getCountry());
        return ResponseEntity.status(HttpStatus.CREATED).body(createContractor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ContractorDto contractorDto) {
        Optional<ContractorDto> findContractor = contractorService.findById(id);
        if (findContractor.isPresent()) {
            log.info("Zaktualizowano użytkownika o id = " + id);
            return ResponseEntity.status(HttpStatus.OK).body(contractorService.update(id, contractorDto));
        } else {
            log.error("Użytkownik o id = " + id + " nie istnieje");
            return ResponseEntity.notFound().build();
        }
    }


}

package com.example.zadanie.contractor;

import com.example.zadanie.contractor.domain.Contractor;
import com.example.zadanie.contractor.domain.ContractorService;
import com.example.zadanie.contractor.model.ContractorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ContractorController {

    private final ContractorService contractorService;

    public ContractorController(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @GetMapping("/")
     public ResponseEntity<List<ContractorDto>>findall ()
    {
        List<ContractorDto> all = contractorService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ContractorDto> findById (@PathVariable Long id){
        return contractorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable Long id){

        contractorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/add")
    public ResponseEntity <Contractor> create(@RequestBody Contractor contractor){
        Contractor contractor1 = contractorService.create(contractor);
        return ResponseEntity.status(HttpStatus.CREATED).body(contractor1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable Long id , @RequestBody Contractor contractor ){
        Optional<Contractor> update = contractorService.update(id, contractor);
             return   ResponseEntity.status(HttpStatus.OK).body(update);

    }











}

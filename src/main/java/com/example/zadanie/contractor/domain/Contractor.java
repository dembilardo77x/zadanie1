package com.example.zadanie.contractor.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Setter
@Entity(name = "KONTRAHENT")
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID",nullable = false)
    private Long id;

    @Column(name = "NAZWA")
    private String name;

    @Column(name = "NIP")
    private String nip;

    @Column(name = "ADRES")
    private String address;

    @Column(name = "KOD_POCZTOWY")
    private String postalCode;

    @Column(name = "MIASTO")
    private String city;

    @Column(name = "KRAJ")
    private String country;

    @Column(name = "DATA_UTWORZENIA")
    private LocalDateTime creationDate;

    @Column(name = "DATA_MODYFIKACJI")
    private LocalDateTime versionDate;


}

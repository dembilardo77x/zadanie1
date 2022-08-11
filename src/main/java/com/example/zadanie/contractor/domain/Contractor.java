package com.example.zadanie.contractor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "KONTRAHENT")
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID",nullable = false)
    private Long id;

    @Column(name = "NAZWA",nullable = false)
    private String name;

    @Column(name = "NIP",nullable = false)
    private String nip;

    @Column(name = "ADRES",nullable = false)
    private String address;

    @Column(name = "KOD_POCZTOWY",nullable = false)
    private String postalCode;

    @Column(name = "MIASTO",nullable = false)
    private String city;

    @Column(name = "KRAJ",nullable = false)
    private String country;

    @Column(name = "DATA_UTWORZENIA",nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "DATA_MODYFIKACJI")
    private LocalDateTime versionDate;
}

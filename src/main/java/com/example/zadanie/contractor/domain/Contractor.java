package com.example.zadanie.contractor.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity(name = "KONTRAHENT")

public class Contractor{
    @Id
    //@SequenceGenerator(name = "id_seq", sequenceName = "id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAZWA")
    private String name;

    @Column(name="NIP")
    private String nip;

    @Column(name="ADRES")
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

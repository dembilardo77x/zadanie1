package com.example.zadanie.contractor.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
}

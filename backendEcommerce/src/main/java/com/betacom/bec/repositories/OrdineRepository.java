package com.betacom.bec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.bec.models.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Integer> {

}

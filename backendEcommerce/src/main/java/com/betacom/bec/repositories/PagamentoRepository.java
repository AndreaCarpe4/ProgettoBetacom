package com.betacom.bec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.bec.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}

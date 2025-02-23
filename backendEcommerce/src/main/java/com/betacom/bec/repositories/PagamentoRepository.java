package com.betacom.bec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.bec.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

	List<Pagamento> findByUtente_Id(Integer utenteId);

}

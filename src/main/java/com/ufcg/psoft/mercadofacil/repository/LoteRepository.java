package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.psoft.mercadofacil.model.Lote;

import java.util.Optional;

public interface LoteRepository extends JpaRepository<Lote, Long>{

    Optional<Lote> findById(long id);
}
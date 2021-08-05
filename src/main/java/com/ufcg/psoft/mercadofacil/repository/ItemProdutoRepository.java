package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.ItemProduto;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Long> {

    Optional<ItemProduto> findByid(long id);

}

package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.DTO.ItemProdutoDTO;
import com.ufcg.psoft.mercadofacil.model.Carrinho;

import java.util.Optional;

public interface CarrinhoService {

    public Carrinho criaCarrinho();

    public void salvarCarrinho(Carrinho carrinho);

    public void removeCarrinho(Carrinho carrinho);

    public void limpaCarrinho(long id);

    public Optional<Carrinho> getCarrinhoById(long id);
}

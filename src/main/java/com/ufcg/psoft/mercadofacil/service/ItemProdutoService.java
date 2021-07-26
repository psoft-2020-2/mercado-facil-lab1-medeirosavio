package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.DTO.ItemProdutoDTO;
import com.ufcg.psoft.mercadofacil.model.ItemProduto;

import java.util.Optional;

public interface ItemProdutoService {

    public Optional <ItemProduto> getItemProdutoById(long id);

    public ItemProduto criaItem(ItemProdutoDTO itemProdutoDTO);

    public void salvaItem(ItemProduto itemProduto);

    public void removeItem(ItemProduto itemProduto);
}

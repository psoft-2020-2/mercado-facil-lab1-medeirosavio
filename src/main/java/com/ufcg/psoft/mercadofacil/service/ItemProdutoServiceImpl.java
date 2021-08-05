package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.DTO.ItemProdutoDTO;
import com.ufcg.psoft.mercadofacil.model.ItemProduto;
import com.ufcg.psoft.mercadofacil.repository.ItemProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemProdutoServiceImpl implements ItemProdutoService{

    @Autowired
    private ItemProdutoRepository itemProdutoRepository;


    public Optional<ItemProduto> getItemProdutoById(long id) {
        return itemProdutoRepository.findByid(id);
    }


    public ItemProduto criaItem(ItemProdutoDTO itemProdutoDTO) {
        ItemProduto itemProduto = new ItemProduto(itemProdutoDTO.getNome(),
                itemProdutoDTO.getFabricante(),itemProdutoDTO.getPreco());

        return itemProduto;

    }

    public void salvaItem(ItemProduto itemProduto) { itemProdutoRepository.save(itemProduto);}

    public void removeItem(ItemProduto itemProduto) { itemProdutoRepository.delete(itemProduto);}
}

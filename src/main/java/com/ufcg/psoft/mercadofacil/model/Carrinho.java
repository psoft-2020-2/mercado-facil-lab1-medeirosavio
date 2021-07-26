package com.ufcg.psoft.mercadofacil.model;

import com.ufcg.psoft.mercadofacil.DTO.ItemProdutoDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<ItemProduto> itensDeProdutos ;

    public Carrinho(){
        this.id = id;
        this.itensDeProdutos = new ArrayList<>();
    }

    public List<ItemProduto> getItensDeProdutos() {
        return itensDeProdutos;
    }

    public Long getId() {
        return id;
    }

    public void adicionaItemDeProduto (ItemProduto itemProduto){
        itensDeProdutos.add(itemProduto);
    }

    public void removeItemDeProduto (ItemProduto itemProduto){ itensDeProdutos.remove(itemProduto); }


}

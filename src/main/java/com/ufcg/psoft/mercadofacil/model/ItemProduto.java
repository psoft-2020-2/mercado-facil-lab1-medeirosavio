package com.ufcg.psoft.mercadofacil.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String fabricante;
    private BigDecimal preco;

    public ItemProduto(String nome,String fabricante,BigDecimal preco){
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public ItemProduto() {

    }
}

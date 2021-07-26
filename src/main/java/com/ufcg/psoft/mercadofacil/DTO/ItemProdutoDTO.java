package com.ufcg.psoft.mercadofacil.DTO;

import java.math.BigDecimal;

public class ItemProdutoDTO {

    private long idProduto;
    private long idCliente;
    private long idLote;
    private String nome;
    private String fabricante;
    private BigDecimal preco;
    private int numeroDeItens;

    public long getIdProduto() {
        return idProduto;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public long getIdLote() {
        return idLote;
    }

    public int getNumeroDeItens() {
        return numeroDeItens;
    }

    public String getNome() {
        return nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}

package com.ufcg.psoft.mercadofacil.DTO;

import java.math.BigDecimal;

public class CompraDTO {

    private long idLote;
    private String nome;
    private String fabricante;
    private BigDecimal preco;
    private int numeroDeItens;

    public long getIdLote() {
        return idLote;
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

    public int getNumeroDeItens() {
        return numeroDeItens;
    }
}

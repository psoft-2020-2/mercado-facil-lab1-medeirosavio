package com.ufcg.psoft.mercadofacil.DTO;

import java.math.BigDecimal;
import java.util.Optional;

public class CompraDTO {

    private long idLote;
    private String nome;
    private String fabricante;
    private BigDecimal preco;
    private int numeroDeItens;
    private Optional<String> metodoPagamento;
    private Optional<String> perfilCliente;

    public Optional<String> getPerfilCliente() {
        return perfilCliente;
    }

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

    public Optional<String> getMetodoPagamento() { return metodoPagamento; }
}

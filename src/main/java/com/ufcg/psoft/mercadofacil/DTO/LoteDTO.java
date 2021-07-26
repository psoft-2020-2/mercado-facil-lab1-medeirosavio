package com.ufcg.psoft.mercadofacil.DTO;

import java.util.Date;

public class LoteDTO {

    private int numeroDeItens;
    private Date dataDeValidade;
    private long idProduto;


    public int getNumeroDeItens() {
        return numeroDeItens;
    }

    public Date getDataDeValidade() {
        return dataDeValidade;
    }

    public long getIdProduto() {
        return idProduto;
    }
}


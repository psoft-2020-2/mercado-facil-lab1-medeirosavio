package com.ufcg.psoft.mercadofacil.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<ItemProduto> itensComprados;

    public Compra(){
        this.id = id;
        this.itensComprados = new ArrayList<>();
    }
    public List<ItemProduto> getItensComprados() {
        return itensComprados;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValorCompra() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for(int i=0;i<itensComprados.size();i++){
            valorTotal.add(itensComprados.get(i).getPreco());
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", itensComprados=" + itensComprados +
                '}';
    }
}

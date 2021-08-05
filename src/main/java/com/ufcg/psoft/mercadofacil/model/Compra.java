package com.ufcg.psoft.mercadofacil.model;

import org.springframework.beans.factory.annotation.Autowired;

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

    private static Pagamento metodoPagamento;

    public Compra(){
        this.id = id;
        this.itensComprados = new ArrayList<>();
        this.metodoPagamento = new MetodoPagamento();
    }
    public List<ItemProduto> getItensComprados() {
        return itensComprados;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal selecionaBoleto(){
        BigDecimal valorTotal = new BigDecimal("0");

        for(int i=0;i<itensComprados.size();i++){
            valorTotal.add(itensComprados.get(i).getPreco());
        }
        return valorTotal;
    }

    public BigDecimal selecionaPayPal(){
        BigDecimal valorTotal = new BigDecimal("0");

        for(int i=0;i<itensComprados.size();i++){
            valorTotal.add(itensComprados.get(i).getPreco());
        }
        valorTotal.add(valorTotal.multiply(new BigDecimal("0.02")));
        return valorTotal;
    }

    public BigDecimal selecionaCartao(){
        BigDecimal valorTotal = new BigDecimal("0");

        for(int i=0;i<itensComprados.size();i++){
            valorTotal.add(itensComprados.get(i).getPreco());
        }
        valorTotal.add(valorTotal.multiply(new BigDecimal("0.05")));
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

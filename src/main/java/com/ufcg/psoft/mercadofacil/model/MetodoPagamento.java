package com.ufcg.psoft.mercadofacil.model;


import java.util.Optional;

public class MetodoPagamento implements Pagamento{

    private String boleto;
    private String paypal;
    private String cartao;

    public MetodoPagamento(){
        this.boleto = boleto;
        this.paypal = paypal;
        this.cartao = cartao;
    }

    @Override
    public String getBoleto() {
        return boleto;
    }

    @Override
    public String getPayPal() {
        return paypal;
    }

    @Override
    public String getCartao() {
        return cartao;
    }
}

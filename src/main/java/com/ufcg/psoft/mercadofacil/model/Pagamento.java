package com.ufcg.psoft.mercadofacil.model;


import java.util.Optional;

public interface Pagamento {

     public String getBoleto();

     public String getCartao();

     public String getPayPal();
}

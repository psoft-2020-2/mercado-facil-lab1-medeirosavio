package com.ufcg.psoft.mercadofacil.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroCarrinho {

    static final String SEM_PRODUTO_NO_CARRINHO = "Esse produto não está no carrinho";

    public static ResponseEntity<CustomErrorType> erroSemProdutoNoCarrinho() {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroCarrinho.SEM_PRODUTO_NO_CARRINHO),
                HttpStatus.NO_CONTENT);
    }

    public static ResponseEntity<?> erroSemProdutoNoCarrinho(long id) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroCarrinho.SEM_PRODUTO_NO_CARRINHO, id)),
                HttpStatus.NOT_FOUND);
    }
}

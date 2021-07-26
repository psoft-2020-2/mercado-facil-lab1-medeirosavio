package com.ufcg.psoft.mercadofacil.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroCompra {

    static final String SEM_COMPRAS_CADASTRADAS = "Não há compras cadastradas";

    public static ResponseEntity<CustomErrorType> erroSemComprasCadastradas() {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroCompra.SEM_COMPRAS_CADASTRADAS),
                HttpStatus.NO_CONTENT);
    }

    public static ResponseEntity<?> erroSemComprasCadastradas(long id) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroCompra.SEM_COMPRAS_CADASTRADAS, id)),
                HttpStatus.NOT_FOUND);
    }

}

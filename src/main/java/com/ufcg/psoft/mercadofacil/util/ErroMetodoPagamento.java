package com.ufcg.psoft.mercadofacil.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroMetodoPagamento {

    static final String SEM_PAGAMENTO_CADASTRADO = "Método de pagamento indisponível";

    public static ResponseEntity<CustomErrorType> erroSemMetodoPagamentoCadastrado() {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroMetodoPagamento.SEM_PAGAMENTO_CADASTRADO),
                HttpStatus.NO_CONTENT);
    }


}

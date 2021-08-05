package com.ufcg.psoft.mercadofacil.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroLote {

	static final String SEM_LOTES_CADASTRADOS = "Não há lotes cadastrados";
	
	public static ResponseEntity<CustomErrorType> erroSemLotesCadastrados() {		
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroLote.SEM_LOTES_CADASTRADOS),
				HttpStatus.NO_CONTENT);
	}

    public static ResponseEntity<?> erroSemLotesCadastrados(long id) {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroLote.SEM_LOTES_CADASTRADOS, id)),
				HttpStatus.NOT_FOUND);
    }
}


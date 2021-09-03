package com.ufcg.psoft.mercadofacil.DTO;

import java.math.BigDecimal;

public class ProdutoDTO {

	private String nome;

	private BigDecimal preco;

	private String codigoBarra;

	private String fabricante;
	
	private String categoria;

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}


	public String getCodigoBarra() {
		return codigoBarra;
	}


	public String getFabricante() {
		return fabricante;
	}


	public String getCategoria() {
		return categoria;
	}

}

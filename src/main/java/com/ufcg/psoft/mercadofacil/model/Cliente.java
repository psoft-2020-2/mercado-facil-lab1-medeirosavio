package com.ufcg.psoft.mercadofacil.model;

import com.ufcg.psoft.mercadofacil.DTO.ItemProdutoDTO;

import javax.persistence.*;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Carrinho carrinho;
	
	private Long CPF;
	
	private String nome;

	private Integer idade;

	private String endereco;

	public Cliente() {}

	public Cliente(Long cpf, String nome, Integer idade, String endereco) {
		this.CPF = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}


	public Long getId() {
		return id;
	}

	public Long getCpf() {
		return CPF;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void adicionaProdutoNoCarrinho(ItemProduto itemProduto){
		this.carrinho.adicionaItemDeProduto(itemProduto);
	}

	public Integer contaItensNoCarrinho(Carrinho carrinho){
		return carrinho.getItensDeProdutos().size();
	}

	public String finalizaCompra(Compra compra){return compra.toString();}

}

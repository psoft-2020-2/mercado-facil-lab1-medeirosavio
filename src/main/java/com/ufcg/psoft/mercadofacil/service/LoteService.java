package com.ufcg.psoft.mercadofacil.service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ufcg.psoft.mercadofacil.DTO.LoteDTO;
import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;

public interface LoteService {
	
	public List<Lote> listarLotes();

	public void salvarLote(Lote lote);
	
	public Lote criaLote(int numItens, Produto produto, Date dataDeValidade);

	public Optional<Lote> getLoteById(Long id);

	public Lote atualizaLote(LoteDTO loteDTO,Lote lote);

}

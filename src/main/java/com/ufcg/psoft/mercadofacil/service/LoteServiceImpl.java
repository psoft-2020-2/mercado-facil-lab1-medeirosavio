package com.ufcg.psoft.mercadofacil.service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ufcg.psoft.mercadofacil.DTO.ClienteDTO;
import com.ufcg.psoft.mercadofacil.DTO.LoteDTO;
import com.ufcg.psoft.mercadofacil.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.LoteRepository;

@Service
public class LoteServiceImpl implements LoteService {
	
	@Autowired
	private LoteRepository loteRepository;
	
	public List<Lote> listarLotes() {
		return loteRepository.findAll();
	}

	public void salvarLote(Lote lote) {
		loteRepository.save(lote);		
	}

	public Lote criaLote(int numItens, Produto produto,Date dataDeValidade) {
		Lote lote = new Lote(numItens,produto,dataDeValidade);
		return lote;
	}

	public Optional<Lote> getLoteById(Long id) { return loteRepository.findById(id);
	}

	public Lote atualizaLote(LoteDTO loteDTO,Lote lote){
		lote.setDataDeValidade(loteDTO.getDataDeValidade());
		lote.setNumeroDeItens(loteDTO.getNumeroDeItens());

		return  lote;

	}


}

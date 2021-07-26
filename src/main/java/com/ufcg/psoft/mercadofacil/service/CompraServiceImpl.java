package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.DTO.CompraDTO;
import com.ufcg.psoft.mercadofacil.model.Compra;
import com.ufcg.psoft.mercadofacil.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService{

    @Autowired
    private CompraRepository compraRepository;

    public String efetuaPagamento(){
        Compra compra = new Compra();
        String retorno = "Valor Total R$" + compra.getValorCompra();
        return retorno;
    }

    public Compra efetuaCompra(long id){
        Optional<Compra> compraOptional = compraRepository.findById(id);
        Compra compra = compraOptional.get();
        return compra;
    }

    public void salvarCompra(Compra compra){ compraRepository.save(compra);}

    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    public Optional<Compra> findCompraById(long id){ return  compraRepository.findById(id);}
}

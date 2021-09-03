package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Compra;
import com.ufcg.psoft.mercadofacil.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService{

    @Autowired
    private CompraRepository compraRepository;


    @Override
    public BigDecimal selecionaPagamentoBoleto() {
        Compra compra = new Compra();
        return compra.selecionaBoleto();
    }

    @Override
    public BigDecimal selecionaPagamentoCartao() {
        Compra compra = new Compra();
        return compra.selecionaCartao();
    }

    @Override
    public BigDecimal selecionaPagamentoPayPal() {
        Compra compra = new Compra();
        return compra.selecionaPayPal();
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

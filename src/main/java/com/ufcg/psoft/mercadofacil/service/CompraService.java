package com.ufcg.psoft.mercadofacil.service;
import com.ufcg.psoft.mercadofacil.model.Compra;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CompraService{

    public BigDecimal selecionaPagamentoBoleto();

    public BigDecimal selecionaPagamentoCartao();

    public BigDecimal selecionaPagamentoPayPal();

    public Compra efetuaCompra(long id);

    public void salvarCompra(Compra compra);

    public List<Compra> listarCompras();

    public Optional<Compra> findCompraById(long id);



}

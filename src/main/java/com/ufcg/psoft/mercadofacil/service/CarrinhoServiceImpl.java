package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.DTO.ItemProdutoDTO;
import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho criaCarrinho() {
        Carrinho carrinho = new Carrinho();
        return carrinho;
    }

    public void salvarCarrinho(Carrinho carrinho) {
        carrinhoRepository.save(carrinho);
    }

    public void removeCarrinho(Carrinho carrinho) {carrinhoRepository.delete(carrinho);}

    public void limpaCarrinho(long id){
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
        Carrinho carrinho = carrinhoOptional.get();
        carrinho.getItensDeProdutos().clear();
    }

    @Override
    public Optional<Carrinho> getCarrinhoById(long id) {
        return carrinhoRepository.findById(id);
    }
}

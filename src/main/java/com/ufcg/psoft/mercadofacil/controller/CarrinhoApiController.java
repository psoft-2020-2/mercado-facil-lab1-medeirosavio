package com.ufcg.psoft.mercadofacil.controller;

import com.ufcg.psoft.mercadofacil.DTO.ItemProdutoDTO;
import com.ufcg.psoft.mercadofacil.model.*;
import com.ufcg.psoft.mercadofacil.repository.LoteRepository;
import com.ufcg.psoft.mercadofacil.service.*;
import com.ufcg.psoft.mercadofacil.util.ErroCarrinho;
import com.ufcg.psoft.mercadofacil.util.ErroCliente;
import com.ufcg.psoft.mercadofacil.util.ErroLote;
import com.ufcg.psoft.mercadofacil.util.ErroProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin
public class CarrinhoApiController {

    @Autowired
    CarrinhoService carrinhoService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    LoteService loteService;

    @Autowired
    ItemProdutoService itemProdutoService;

    @RequestMapping(value = "/clientes/{idcliente}/carrinho", method = RequestMethod.POST)
    public ResponseEntity<?> criarCarrinho(@PathVariable ("idcliente") long idcliente,@RequestBody ItemProdutoDTO itemProdutoDTO){

        Optional<Produto> produtoOptional = produtoService.getProdutoById(itemProdutoDTO.getIdProduto());
        Optional<Cliente> clienteOptional = clienteService.getClienteById(itemProdutoDTO.getIdCliente());
        Optional<Lote> loteOptional = loteService.getLoteById(itemProdutoDTO.getIdLote());

        if (!produtoOptional.isPresent()) {
            return ErroProduto.erroProdutoNaoEnconrtrado(itemProdutoDTO.getIdProduto());
        }

        if(!clienteOptional.isPresent()) {
            return ErroCliente.erroClienteNaoEnconrtrado(itemProdutoDTO.getIdCliente());
        }

        if(!loteOptional.isPresent()) {
            return ErroLote.erroSemLotesCadastrados(itemProdutoDTO.getIdLote());
        }

        Produto produto = produtoOptional.get();
        Cliente cliente = clienteOptional.get();
        Lote lote = loteOptional.get();
        ItemProduto itemProduto = itemProdutoService.criaItem(itemProdutoDTO);

        if(!produto.isDisponivel()){
            return ErroProduto.erroSemProdutosCadastrados();
        }

        Carrinho carrinho = carrinhoService.criaCarrinho();
        carrinho.adicionaItemDeProduto(itemProduto);

        lote.subtraiItensCliente(itemProdutoDTO.getNumeroDeItens());
        cliente.adicionaProdutoNoCarrinho(itemProduto);

        carrinhoService.salvarCarrinho(carrinho);

        return new ResponseEntity<>(carrinho, HttpStatus.CREATED);


    }

    @RequestMapping(value = "/carrinhos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarCarrinho(@PathVariable("id") long id
                                                        ,@RequestBody ItemProdutoDTO itemProdutoDTO){

        Optional<Produto> produtoOptional = produtoService.getProdutoById(itemProdutoDTO.getIdProduto());
        Optional<Cliente> clienteOptional = clienteService.getClienteById(itemProdutoDTO.getIdCliente());
        Optional<Lote> loteOptional = loteService.getLoteById(itemProdutoDTO.getIdLote());

        if (!produtoOptional.isPresent()) {
            return ErroProduto.erroProdutoNaoEnconrtrado(itemProdutoDTO.getIdProduto());
        }

        if(!clienteOptional.isPresent()) {
            return ErroCliente.erroClienteNaoEnconrtrado(itemProdutoDTO.getIdCliente());
        }

        if(!loteOptional.isPresent()) {
            return ErroLote.erroSemLotesCadastrados(itemProdutoDTO.getIdLote());
        }

        Produto produto = produtoOptional.get();
        ItemProduto itemProduto = itemProdutoService.criaItem(itemProdutoDTO);

        if(!produto.isDisponivel()){
            return ErroProduto.erroSemProdutosCadastrados();
        }

        Optional<Carrinho> optionalCarrinho = carrinhoService.getCarrinhoById(id);
        Carrinho carrinho = optionalCarrinho.get();

        carrinho.adicionaItemDeProduto(itemProduto);

        carrinhoService.salvarCarrinho(carrinho);

        return new ResponseEntity<>(carrinho, HttpStatus.OK);

    }

    @RequestMapping(value = "/clientes/{idcarrinho}/{iditem}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removerProdutoCarrinho(@PathVariable("idcarrinho") long idCarrinho,@PathVariable("iditem") long idItem
            ,@RequestBody ItemProdutoDTO itemProdutoDTO){

        Optional<ItemProduto> optionalItemProduto = itemProdutoService.getItemProdutoById(idItem);
        Optional<Cliente> clienteOptional = clienteService.getClienteById(itemProdutoDTO.getIdCliente());
        Optional<Carrinho> carrinhoOptional =carrinhoService.getCarrinhoById(idCarrinho);

        if(!optionalItemProduto.isPresent()){
            return ErroCarrinho.erroSemProdutoNoCarrinho();
        }

        Optional<ItemProduto> itemProdutoOptional = itemProdutoService.getItemProdutoById(idItem);

        Carrinho carrinho = carrinhoOptional.get();
        Cliente cliente = clienteOptional.get();
        ItemProduto itemProduto = itemProdutoOptional.get();

        carrinho.removeItemDeProduto(itemProduto);

        if(cliente.contaItensNoCarrinho(carrinho)==0){
            carrinhoService.removeCarrinho(carrinho);
        }

        return new ResponseEntity<Carrinho>(HttpStatus.OK);

    }



}

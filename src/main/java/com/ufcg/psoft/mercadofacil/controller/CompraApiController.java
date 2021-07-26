package com.ufcg.psoft.mercadofacil.controller;


import com.ufcg.psoft.mercadofacil.DTO.CompraDTO;
import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Compra;
import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.service.CarrinhoService;
import com.ufcg.psoft.mercadofacil.service.CompraService;
import com.ufcg.psoft.mercadofacil.service.LoteService;
import com.ufcg.psoft.mercadofacil.util.ErroCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin
public class CompraApiController {

    @Autowired
    CompraService compraService;

    @Autowired
    LoteService loteService;

    @Autowired
    CarrinhoService carrinhoService;

    @RequestMapping(value="/clientes/{idcliente}/{idcarrinho}/{id]" ,method = RequestMethod.POST)
        public ResponseEntity<?> efetuaCompra(@PathVariable("idcliente")long idCliente,@PathVariable("idcarrinho")long idCarrinho
                                                ,@PathVariable ("id") long idCompra,@RequestBody CompraDTO compraDTO){

        Optional<Lote> loteOptional = loteService.getLoteById(compraDTO.getIdLote());
        Optional<Carrinho> carrinhoOptional = carrinhoService.getCarrinhoById(idCarrinho);

        String efetuaPagamento = compraService.efetuaPagamento();

        Compra compra  = compraService.efetuaCompra(idCompra);
        Lote lote = loteOptional.get();
        Carrinho carrinho = carrinhoOptional.get();

        lote.subtraiItensCliente(compraDTO.getNumeroDeItens());
        carrinhoService.removeCarrinho(carrinho);

        return new ResponseEntity<Compra>(compra, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/clientes/{idcliente}/descartar/{idcarrinho}/", method = RequestMethod.DELETE)
        public ResponseEntity<?> descartarCompra(@PathVariable("idcliente")long idCliente,@PathVariable("idcarrinho")long idCarrinho){

        Optional<Carrinho> carrinhoOptional = carrinhoService.getCarrinhoById(idCarrinho);

        if(carrinhoOptional.isEmpty()){
            return ErroCompra.erroSemComprasCadastradas();
        }


        carrinhoService.limpaCarrinho(idCarrinho);


        Carrinho carrinho = carrinhoOptional.get();

        carrinhoService.removeCarrinho(carrinho);

        return new ResponseEntity<>(carrinho, HttpStatus.OK);
    }

    @RequestMapping(value = "/clientes/{idcliente}/listacompras", method = RequestMethod.GET)
        public ResponseEntity<?> listarCompras(@PathVariable("idcliente")long idCliente){

        List<Compra> compras = compraService.listarCompras();

        if(compras.isEmpty()){
            return ErroCompra.erroSemComprasCadastradas();
        }

        return new ResponseEntity<List<Compra>>(compras, HttpStatus.OK);

    }

    @RequestMapping(value = "/clientes/{idcliente}/{idcompra}/consultar",method = RequestMethod.GET)
    public ResponseEntity<?> consultarCompra(@PathVariable("idcliente")long idCliente,@PathVariable("idcompra")long idCompra){

        Optional<Compra> compraOptional = compraService.findCompraById(idCompra);

        if(!compraOptional.isPresent()){
            return ErroCompra.erroSemComprasCadastradas();
        }

        return new ResponseEntity<Compra>(compraOptional.get(), HttpStatus.OK);

    }

}

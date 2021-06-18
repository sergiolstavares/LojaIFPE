package com.ifpe.Loja.controller;


import com.ifpe.Loja.model.Produto;
import com.ifpe.Loja.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;


    @PostMapping("/cadastro")
    public Produto cadastrarProduto(@RequestBody Produto produto){
        return produtoService.cadastroProduto(produto);
    }

    @GetMapping("/buscar")
    public List<Produto> retornarProdutos(){
        return produtoService.retornarProdutos();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Produto> retornarProdutoId(@PathVariable Long id){
        return produtoService.retornarProdutoId(id);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarProduto(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.updateById(id, produto);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id){
        return produtoService.deleteById(id);
    }



}

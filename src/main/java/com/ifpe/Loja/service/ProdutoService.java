package com.ifpe.Loja.service;

import com.ifpe.Loja.exception.PersonNotFoundException;
import com.ifpe.Loja.model.Cliente;
import com.ifpe.Loja.model.Produto;
import com.ifpe.Loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastroProduto(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public List<Produto> retornarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> retornarProdutoId(Long numeroRegistro) {
        Optional<Produto> produto = produtoRepository.findById(numeroRegistro);
        return produto;
    }

    public String updateById(Long numeroRegistro, Produto produto) {
        Optional<Produto> produtoAtualizar = produtoRepository.findById(numeroRegistro);

        if (produtoAtualizar.isPresent()) {
            produtoRepository.save(produto);
            return "Produto atualizado" + produto;
        } else {
            return "Produto não existe";
        }

    }


    public String deleteById(Long numeroRegistro) {
        Optional<Produto> produtoADeletar = produtoRepository.findById(numeroRegistro);
        if (produtoADeletar.isPresent()) {
            produtoRepository.deleteById(numeroRegistro);
            return "produto deletado com sucesso ";
        } else {
            return "Cliente não existe";
        }
    }
}

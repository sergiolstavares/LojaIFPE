package com.ifpe.Loja.controller;


import com.ifpe.Loja.exception.PersonNotFoundException;
import com.ifpe.Loja.model.Cliente;
import com.ifpe.Loja.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/cadastro")
    public Cliente cadastroCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastroCliente(cliente);
    }

    @GetMapping("/busca")
    public List<Cliente> retornarClientes() {
        return clienteService.retornarClientes();
    }

    @GetMapping("/busca/{id}")
    public Optional<Cliente> retornaCliente(@PathVariable("id") Long id) throws PersonNotFoundException {
       return clienteService.retornarClienteId(id);
    }

    @PutMapping( "/atualizar/{id}")
    public String atualizarCliente(@PathVariable Long id,@RequestBody Cliente cliente){
       return clienteService.updateById(id, cliente);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable("id") Long id){
        return clienteService.deleteById(id);
    }

}

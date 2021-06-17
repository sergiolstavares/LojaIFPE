package com.ifpe.Loja.controller;


import com.ifpe.Loja.model.Cliente;
import com.ifpe.Loja.repository.ClienteRepository;
import com.ifpe.Loja.service.LojaService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaService lojaService;


    @PostMapping
    public String cadastroCliente(@RequestBody Cliente cliente) {
        lojaService.criarCliente(cliente);
        return "Cliente Salvo";
    }

//    @GetMapping
//    public List<Cliente> retornarClientes() {
//        List<Cliente> clientes = clienteRepository.findAll();
//        return clientes;
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Cliente> retornaCliente(@PathVariable("id") Long id) {
//        Optional<Cliente> cliente = clienteRepository.findById(id);
//        return cliente;
//    }
//
//    @PutMapping(path = "/atualizar")
//    public Cliente atualizarCliente(@RequestBody Cliente cliente){
//
//       clienteRepository.save(cliente);
//
//       return cliente;
//    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable("id") Long id){
        lojaService.deleteById(id);
        return "Cliente deletado";
    }

}

package com.ifpe.Loja.service;

import com.ifpe.Loja.model.Cliente;
import com.ifpe.Loja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.StyledEditorKit;

@Service
public class LojaService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Boolean criarCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return true;
    }



    public Boolean deleteById(Long id){
        clienteRepository.deleteById(id);
        return true;
    }

}

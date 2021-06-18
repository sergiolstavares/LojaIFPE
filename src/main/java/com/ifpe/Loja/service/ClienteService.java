package com.ifpe.Loja.service;

import com.ifpe.Loja.exception.PersonNotFoundException;
import com.ifpe.Loja.model.Cliente;
import com.ifpe.Loja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastroCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    public List<Cliente> retornarClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> retornarClienteId(Long id) throws PersonNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(!cliente.isPresent()){
            throw new PersonNotFoundException(id);
        }
        return cliente;
    }

    public String updateById(Long id, Cliente cliente){
        Optional<Cliente> clienteAtualizar = clienteRepository.findById(id);

        if(clienteAtualizar.isPresent()) {
            clienteRepository.save(cliente);
            return "Cliente atualizado" + cliente ;
        }
        else{
            return "Cliente não existe";
        }

    }


    public String deleteById(Long id){
        Optional<Cliente> clienteADeletar = clienteRepository.findById(id);
        if(clienteADeletar.isPresent()){
            clienteRepository.deleteById(id);
            return "Cliente deletado com sucesso ";
        }
        else{
            return "Cliente não existe";
        }
    }


}

package com.ifpe.Loja.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotEmpty
    private String nome;

    @Column
    @CPF
    @NotEmpty
    private String cpf;

    @Column
    @NotEmpty
    private String endereco;

    @Column
    @NotEmpty
    private String idade;

    @Column
    @NotEmpty
    private String numero;


}

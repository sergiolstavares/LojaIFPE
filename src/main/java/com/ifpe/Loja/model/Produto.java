package com.ifpe.Loja.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Produto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroRegistro;
    @Column
    private String nome;
    @Column
    private String categoria;
    @Column
    private Float valor;



}

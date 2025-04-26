package com.sea.desafio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Address endereco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> telefone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> email;


}

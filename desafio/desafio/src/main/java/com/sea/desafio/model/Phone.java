package com.sea.desafio.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numero;

    private TipoTelefone tipoTelefone;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}

package com.sea.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Email é obrigatório")
    @jakarta.validation.constraints.Email(message = "Email deve ser válido")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Email deve seguir o formato adequado (exemplo@dominio.com)")
    private String email;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}

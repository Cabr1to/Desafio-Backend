package com.sea.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Nome permite apenas letras, números e espaços")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotNull(message = "Endereço é obrigatório")
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Address endereco;

    @NotEmpty(message = "Pelo menos um telefone deve ser cadastrado")
    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> telefone;

    @NotEmpty(message = "Pelo menos um email deve ser cadastrado")
    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> email;
}

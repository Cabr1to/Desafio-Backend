package com.sea.desafio.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Número de telefone é obrigatório")
    @Pattern(regexp = "^[0-9]{10,11}$", message = "Número de telefone deve conter apenas dígitos (10 para fixo ou 11 para celular)")
    private String numero;

    @NotNull(message = "Tipo de telefone é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Validacao
    public boolean isValid() {
        if (numero == null || tipoTelefone == null) {
            return false;
        }

        // Celular
        if (tipoTelefone == TipoTelefone.CELULAR && numero.replaceAll("\\D", "").length() != 11) {
            return false;
        }

        // Telefone fixo
        if ((tipoTelefone == TipoTelefone.RESIDENCIAL || tipoTelefone == TipoTelefone.COMERCIAL)
                && numero.replaceAll("\\D", "").length() != 10) {
            return false;
        }

        return true;
    }
}

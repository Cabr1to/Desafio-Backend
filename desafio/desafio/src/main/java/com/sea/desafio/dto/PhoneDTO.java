package com.sea.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sea.desafio.model.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDTO {
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String numeroSemMascara;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String numeroComMascara;

    private TipoTelefone tipo;
}
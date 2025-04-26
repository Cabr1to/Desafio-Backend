package com.sea.desafio.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sea.desafio.model.TipoTelefone;

public class PhoneDTO {
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String numeroSemMascara;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String numeroComMascara;

    private TipoTelefone tipo;
}
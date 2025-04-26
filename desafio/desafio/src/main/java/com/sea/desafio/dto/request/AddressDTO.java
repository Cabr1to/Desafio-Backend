package com.sea.desafio.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String cepSemMascara;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String cepComMascara;

    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
}
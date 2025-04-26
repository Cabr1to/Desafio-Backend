package com.sea.desafio.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ClientDTO {
    private Long id;

    private String nome;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String cpfSemMascara;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String cpfComMascara;

    private AddressDTO endereco;

    private List<PhoneDTO> telefone;

    private List<EmailDTO> email;
}
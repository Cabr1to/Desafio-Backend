package com.sea.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
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
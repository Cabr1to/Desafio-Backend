package com.sea.desafio.mapper;

import com.sea.desafio.dto.AddressDTO;
import com.sea.desafio.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO toDTO(Address address) {
        if (address == null) return null;

        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setCepComMascara(formatCEP(address.getCep()));
        dto.setLogradouro(address.getLogradouro());
        dto.setComplemento(address.getComplemento());
        dto.setBairro(address.getBairro());
        dto.setCidade(address.getCidade());
        dto.setUf(address.getUf());
        return dto;
    }

    public Address toEntity(AddressDTO dto) {
        if (dto == null) return null;

        Address address = new Address();
        // Não definimos ID ao criar uma nova entidade
        address.setCep(dto.getCepSemMascara());
        address.setLogradouro(dto.getLogradouro());
        address.setComplemento(dto.getComplemento());
        address.setBairro(dto.getBairro());
        address.setCidade(dto.getCidade());
        address.setUf(dto.getUf());
        return address;
    }

    private String formatCEP(String cep) {
        if (cep == null || cep.length() != 8) return cep;
        return cep.replaceAll("(\\d{5})(\\d{3})", "$1-$2");
    }
}

package com.sea.desafio.mapper;

import com.sea.desafio.dto.EmailDTO;
import com.sea.desafio.model.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    public EmailDTO toDTO(Email email) {
        if (email == null) return null;

        EmailDTO dto = new EmailDTO();
        dto.setId(email.getId());
        dto.setEndereco(email.getEmail());
        return dto;
    }

    public Email toEntity(EmailDTO dto) {
        if (dto == null) return null;

        Email email = new Email();
        // Não definimos ID ao criar uma nova entidade
        email.setEmail(dto.getEndereco());
        return email;
    }
}

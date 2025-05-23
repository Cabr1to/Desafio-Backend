package com.sea.desafio.mapper;

import com.sea.desafio.dto.PhoneDTO;
import com.sea.desafio.model.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {

    public PhoneDTO toDTO(Phone phone) {
        if (phone == null) return null;

        PhoneDTO dto = new PhoneDTO();
        dto.setId(phone.getId());
        dto.setNumeroComMascara(formatPhoneNumber(phone.getNumero()));
        dto.setTipo(phone.getTipoTelefone());
        return dto;
    }

    public Phone toEntity(PhoneDTO dto) {
        if (dto == null) return null;

        Phone phone = new Phone();
        phone.setNumero(dto.getNumeroSemMascara());
        phone.setTipoTelefone(dto.getTipo());
        return phone;
    }

    private String formatPhoneNumber(String numero) {
        if (numero == null) return null;

        String digits = numero.replaceAll("\\D", "");

        // Formatacao
        if (digits.length() == 10) { // Telefone fixo
            return digits.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
        } else if (digits.length() == 11) { // Celular
            return digits.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
        }

        return numero;
    }
}

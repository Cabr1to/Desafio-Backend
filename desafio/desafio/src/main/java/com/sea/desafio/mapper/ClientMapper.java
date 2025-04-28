package com.sea.desafio.mapper;

import com.sea.desafio.dto.ClientDTO;
import com.sea.desafio.model.Client;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    private final AddressMapper addressMapper;
    private final PhoneMapper phoneMapper;
    private final EmailMapper emailMapper;

    public ClientMapper(AddressMapper addressMapper, PhoneMapper phoneMapper, EmailMapper emailMapper) {
        this.addressMapper = addressMapper;
        this.phoneMapper = phoneMapper;
        this.emailMapper = emailMapper;
    }

    public ClientDTO toDTO(Client client) {
        if (client == null) return null;

        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNome(client.getNome());
        dto.setCpfComMascara(formatCPF(client.getCpf()));
        dto.setEndereco(addressMapper.toDTO(client.getEndereco()));
        dto.setTelefone(client.getTelefone().stream()
                .map(phoneMapper::toDTO)
                .collect(Collectors.toList()));
        dto.setEmail(client.getEmail().stream()
                .map(emailMapper::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public Client toEntity(ClientDTO dto) {
        if (dto == null) return null;

        Client client = new Client();
        client.setNome(dto.getNome());
        client.setCpf(dto.getCpfSemMascara());
        client.setEndereco(addressMapper.toEntity(dto.getEndereco()));
        client.setTelefone(dto.getTelefone().stream()
                .map(phoneMapper::toEntity)
                .collect(Collectors.toList()));
        client.setEmail(dto.getEmail().stream()
                .map(emailMapper::toEntity)
                .collect(Collectors.toList()));
        return client;
    }

    public void updateEntityFromDTO(ClientDTO dto, Client client) {
        if (dto == null || client == null) return;

        // Att campos que podem ser alterados
        if (dto.getNome() != null) {
            client.setNome(dto.getNome());
        }
        if (dto.getCpfSemMascara() != null) {
            client.setCpf(dto.getCpfSemMascara());
        }
    }

    private String formatCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) return cpf;
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}

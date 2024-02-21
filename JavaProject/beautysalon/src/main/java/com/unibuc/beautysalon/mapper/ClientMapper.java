package com.unibuc.beautysalon.mapper;
import com.unibuc.beautysalon.dto.SimpleClientDto;
import com.unibuc.beautysalon.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    // client -> dto
    public SimpleClientDto ClientToSimpleClientDto(Client client) {
        return new SimpleClientDto(client.getId(), client.getName());
    }
}

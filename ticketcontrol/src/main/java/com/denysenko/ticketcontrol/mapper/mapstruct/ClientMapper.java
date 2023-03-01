package com.denysenko.ticketcontrol.mapper.mapstruct;

import com.denysenko.ticketcontrol.controller.dto.ClientDto;
import com.denysenko.ticketcontrol.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    ClientDto toClientDto(Client client);

    Client toClient(ClientDto client);
}

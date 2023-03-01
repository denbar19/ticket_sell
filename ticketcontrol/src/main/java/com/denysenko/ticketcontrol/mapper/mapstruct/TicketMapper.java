package com.denysenko.ticketcontrol.mapper.mapstruct;

import com.denysenko.ticketcontrol.entity.Ticket;
import com.denysenko.ticketcontrol.controller.dto.TicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {

    TicketDto toTicketDto(Ticket ticket);

    Ticket toTicket(TicketDto ticket);
}

package com.denysenko.ticketcontrol.repository;

import com.denysenko.ticketcontrol.entity.Ticket;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TicketRepository extends R2dbcRepository<Ticket, String> {

}

package com.denysenko.ticketcontrol.repository;

import com.denysenko.ticketcontrol.entity.Ticket;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.UUID;

public interface TicketRepository extends R2dbcRepository<Ticket, UUID> {

}

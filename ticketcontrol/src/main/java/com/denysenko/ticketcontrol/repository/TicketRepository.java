package com.denysenko.ticketcontrol.repository;

import com.denysenko.ticketcontrol.entity.Ticket;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends R2dbcRepository<Ticket, UUID> {

    @Query("SELECT * FROM ticket WHERE payment_id IN (:paymnetIds)")
    Flux<Ticket> getTicketsByPaymentsIds(List<String> paymentIds);
}

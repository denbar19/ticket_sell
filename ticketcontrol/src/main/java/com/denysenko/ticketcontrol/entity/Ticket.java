package com.denysenko.ticketcontrol.entity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Table(name = "ticket", schema = "ticket_sell")
@Data
@Builder
public class Ticket {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotNull
    @Column(name = "client_id", nullable = false)
    private UUID clientId;
    @NotNull
    @Column(name = "route_id", nullable = false)
    private UUID routeId;
    @NotNull
    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT NOT NULL")
    private short status;
    @Column(name = "payment_id")
    private UUID paymentId;

}

package com.denysenko.ticketcontrol.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Table(name = "ticket", schema = "ticket_sell")
@Data
@Builder
public class Ticket {

    @Id
    private UUID id;
    @NotNull
    @Column("client_id")
    private UUID clientId;
    @NotNull
    @Column("route_id")
    private UUID routeId;
    @NotNull
    @Column("status")
    private short status;
    @Column("payment_id")
    private UUID paymentId;

}

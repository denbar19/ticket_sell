package com.denysenko.ticketcontrol.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "ticket")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    @Column(name = "client_id", nullable = false)
    private Long clientId;
    @NotNull
    @Column(name = "route_id", nullable = false, unique = true)
    private Long routeId;
    @NotNull
    @Column(name = "status", nullable = false)
    private TicketStatus status;
    @Column(name = "payment_id")
    private Long paymentId;

}

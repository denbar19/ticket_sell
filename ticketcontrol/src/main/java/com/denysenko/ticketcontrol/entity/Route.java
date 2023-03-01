package com.denysenko.ticketcontrol.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "route", schema = "ticket_sell")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Route {

    @Id
    private UUID id;
    @NotNull
    @Column("route_identity")
    private String identity;
    @NotNull
    @Column("departure_station")
    private String departureStation;
    @NotNull
    @Column("departure_date")
    private LocalDateTime departureDate;
    @NotNull
    @Column("price")
    private Long price;
    @NotNull
    @Column("available_seats")
    private Integer availableSeats;

}

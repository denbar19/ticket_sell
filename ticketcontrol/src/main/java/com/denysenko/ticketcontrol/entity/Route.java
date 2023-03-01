package com.denysenko.ticketcontrol.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Id;
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
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotNull
    @Column(name = "route_identity", nullable = false)
    private String identity;
    @NotNull
    @Column(name = "departure_station", nullable = false)
    private String departureStation;
    @NotNull
    @Column(name = "departure_date", nullable = false)
    private LocalDateTime departureDate;
    @NotNull
    @Column(name = "price", nullable = false)
    private Long price;
    @NotNull
    @Column(name = "available_seats", nullable = false)
    private Integer availableSeats;

}

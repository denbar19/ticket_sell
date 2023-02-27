package com.denysenko.ticketcontrol.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route")
@Data
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "route_identity", nullable = false)
    private String identity;
    @Column(name = "departure_station", nullable = false)
    private String departureStation;
    @Column(name = "departure_date", nullable = false)
    private LocalDateTime departureDate;
    @Column(name = "price", nullable = false)
    private Long price;
    @Column(name = "available_seats", nullable = false)
    private Integer availableSeats;

}

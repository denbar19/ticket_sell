package com.denysenko.ticketcontrol.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "route", schema = "public")
@Data
public class Route implements Persistable<UUID> {

    @Id
    @Column("id")
    private UUID id;
    @NonNull
    @Column("route_identity")
    private String identity;
    @NonNull
    @Column("departure_station")
    private String departureStation;
    @NonNull
    @Column("departure_date")
    private LocalDateTime departureDate;
    @NonNull
    @Column("price")
    private Long price;
    @NonNull
    @Column("available_seats")
    private Integer availableSeats;

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}

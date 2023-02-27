package com.denysenko.ticketcontrol.repository;

import com.denysenko.ticketcontrol.entity.Route;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;

public interface RouteRepository extends R2dbcRepository<Route, String> {

    @Query("UPDATE route r SET available_seats = " +
            "(SELECT available_seats from route where id = :routeId) - :count" +
            "    WHERE r.id = :ticketId")
    @NotNull Mono<Route> reduceTickets(@NotNull String routeId, int count);
}

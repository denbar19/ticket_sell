package com.denysenko.ticketcontrol.repository;

import com.denysenko.ticketcontrol.entity.Route;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface RouteRepository extends R2dbcRepository<Route, UUID> {

    @Modifying
    @Query("UPDATE public.route r SET available_seats = available_seats - :count" +
            "    WHERE r.id = :routeId")
    @NonNull Mono<Void> reduceTickets(@NonNull UUID routeId, Integer count);
}

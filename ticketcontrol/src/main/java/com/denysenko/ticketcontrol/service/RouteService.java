package com.denysenko.ticketcontrol.service;

import com.denysenko.ticketcontrol.entity.Route;
import com.denysenko.ticketcontrol.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RouteService {

    private final RouteRepository routeRepository;

    public Mono<Route> saveRoute(Route route) {
        return routeRepository.save(route);
    }

    public Mono<Route> getRouteById(UUID id) {
        return routeRepository.findById(id.toString());
    }
    public Flux<Route> getRoutesById(List<String> routeIds) {
        return routeRepository.findAllById(routeIds);
    }

    public Mono<Route> getRouteByTicketId(UUID routeId) {
        return routeRepository.findById(routeId.toString());
    }

    public Mono<Route> reduceTickets(UUID routeId, int count) {
        return routeRepository.reduceTickets(routeId.toString(), count);
    }

}

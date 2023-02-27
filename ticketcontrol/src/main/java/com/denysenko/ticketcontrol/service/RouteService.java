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
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RouteService {

    private final RouteRepository routeRepository;

    public Optional<Route> getRouteById(String id) {
        return Optional.ofNullable(getRoutesById(List.of(id)).blockFirst());
    }
    public Flux<Route> getRoutesById(List<String> routeIds) {
        return routeRepository.findAllById(routeIds);
    }

    public Mono<Route> getRouteByTicketId(String routeId) {
        return routeRepository.findById(routeId);
    }

    public Mono<Route> reduceTickets(String routeId, int count) {
        return routeRepository.reduceTickets(routeId, count);
    }

}

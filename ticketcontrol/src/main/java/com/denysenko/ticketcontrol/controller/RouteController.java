package com.denysenko.ticketcontrol.controller;

import com.denysenko.ticketcontrol.controller.dto.RouteDto;
import com.denysenko.ticketcontrol.mapper.mapstruct.RouteMapper;
import com.denysenko.ticketcontrol.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Controller
@ResponseBody
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@RequestMapping(value = "/routes")
public class RouteController {

    private final RouteService routeService;
    private final RouteMapper mapper;

    @PostMapping(path = "/route", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<RouteDto> saveRoute(@Validated @RequestBody RouteDto route) {
        return routeService.saveRoute(mapper.toRoute(route))
                           .map(mapper::toRouteDto);
    }

    @GetMapping(path = "/route/{routeId}")
    public Mono<RouteDto> saveRoute(@Validated @NonNull @PathVariable UUID routeId) {
        return routeService.getRouteById(routeId)
                           .map(mapper::toRouteDto);
    }

    @PatchMapping(path = "/route/{routeId}/{quantity}")
    public Mono<RouteDto> reduceTickets(@Validated @NonNull @PathVariable UUID routeId,
                                        @Validated @PathVariable Integer quantity) {
        return routeService.reduceTickets(routeId, quantity)
                           .map(mapper::toRouteDto);
    }

}

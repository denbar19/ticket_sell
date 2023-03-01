package com.denysenko.ticketcontrol.service;

import com.denysenko.ticketcontrol.entity.Route;
import com.denysenko.ticketcontrol.entity.Ticket;
import com.denysenko.ticketcontrol.entity.TicketInfo;
import com.denysenko.ticketcontrol.resource.PaymentResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TicketInfoService {

    private final TicketControlService ticketControlService;
    private final RouteService routeService;
    private final PaymentResource paymentResource;

    // Requests to three table can be made in RouteRepository with 3 table Join
    // this below methods are for kinda all entities separate microservice
    // tickets by routes
    public Map<Route, List<Ticket>> getNewTicketsInfo() {
        // check all NEW payments, get tickets by payment.ids
        List<String> paymentIds = paymentResource.getNewPaymentsIds().
                                                 stream()
                                                 .map(UUID::toString)
                                                 .collect(Collectors.toList());

        List<Ticket> tickets = Optional.ofNullable(ticketControlService.getTicketsByPaymentIds(paymentIds)
                                                                       .collectList()
                                                                       .block())
                                       .orElse(Collections.emptyList());

        List<UUID> routesIds = tickets.stream()
                                      .map(Ticket::getRouteId)
                                      .collect(Collectors.toList());


        // get by tickets.routeId routes
        List<Route> routes = Optional.ofNullable(routeService.getRoutesById(routesIds)
                                                             .collectList()
                                                             .block())
                                     .orElse(Collections.emptyList());


        // collect result in one map for clarity
        return routes.stream()
                     .collect(Collectors.toMap(r -> r,
                                               r -> tickets.stream()
                                                           .filter(t -> t.getRouteId().equals(r.getId()))
                                                           .collect(Collectors.toList())
                     ));
    }

    // list of routes to present them routeIdentity: availableSeats
    public List<Route> getFailedTicketsInfo() {
        List<String> paymentIds = paymentResource.getFailedPaymentsIds().stream()
                                               .map(UUID::toString)
                                               .collect(Collectors.toList());

        List<Ticket> tickets = Optional.ofNullable(ticketControlService.getTicketsByPaymentIds(paymentIds)
                                                                       .collectList()
                                                                       .block())
                                       .orElse(Collections.emptyList());

        List<UUID> routesIds = tickets.stream()
                                      .map(Ticket::getRouteId)
                                      //.map(String::valueOf)
                                      .collect(Collectors.toList());

        return routeService.getRoutesById(routesIds)
                           .collectList()
                           .block();
    }

    public TicketInfo getTicketInfo(UUID ticketId) {
        return TicketInfo.builder()
                         .route(routeService.getRouteByTicketId(ticketId).block())
                         .paymentStatus(paymentResource.getPaymentStatus(ticketId))
                         .build();
    }

}

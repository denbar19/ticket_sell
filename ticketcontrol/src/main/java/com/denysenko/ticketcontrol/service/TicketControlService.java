package com.denysenko.ticketcontrol.service;

import com.denysenko.ticketcontrol.Credentials;
import com.denysenko.ticketcontrol.entity.Route;
import com.denysenko.ticketcontrol.repository.TicketRepository;
import com.denysenko.ticketcontrol.controller.TicketDto;
import com.denysenko.ticketcontrol.entity.Client;
import com.denysenko.ticketcontrol.entity.Ticket;
import com.denysenko.ticketcontrol.mapper.mapstruct.ClientMapper;
import com.denysenko.ticketcontrol.mapper.mapstruct.TicketMapper;
import com.denysenko.ticketcontrol.resource.PaymentResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TicketControlService {

    private final RouteService routeService;
    private final ClientService clientService;
    private final PaymentResource paymentResource;
    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;
    private final ClientMapper clientMapper;

    private final WebClient webClient = WebClient.create("http://localhost:8080/routes/route");

    public Ticket saveTicket(TicketDto ticket) {
        log.debug("TicketBuyService.saveTicket {}", ticket);
        /*if (!routeIsValid(ticket.getRouteId())) {
            return Mono.empty();
        }*/
        /*if (!clientIsValid(clientMapper.toClient(ticket.getClient()))) {
            return Mono.empty();
        }*/
        Mono<Ticket> ticketDb = ticketRepository.save(ticketMapper.toTicket(ticket));
        Optional<Route> routeById = routeService.getRouteById(ticket.getRouteId());
        routeService.reduceTickets(ticket.getRouteId(), 1);
        String id = String.valueOf(ticketDb.block().getId());
        if (Objects.isNull(paymentResource.createPayment(routeById.get().getPrice()))) {
            log.warn("Payment was not created for ticket id: {}", id);
        }
        return ticketDb.block();
    }

    public UUID getTicket(Credentials userId, String routeId) {
        return UUID.randomUUID();
    }

    public Mono<Ticket> getTicketById(String routeId) {
        return ticketRepository.findById(routeId);
    }

    public Flux<Ticket> getTicketsByPaymentIds(List<String> paymentIds) {
        return ticketRepository.findAllById(paymentIds);
    }

    private boolean routeIsValid(String routeId) {
        return routeService.getRouteById(routeId).isPresent();
    }
    private boolean clientIsValid(Client client) {
        return clientService.getClientId(client).isPresent();
    }

}

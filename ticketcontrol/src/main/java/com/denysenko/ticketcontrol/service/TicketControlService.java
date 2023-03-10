package com.denysenko.ticketcontrol.service;

import com.denysenko.ticketcontrol.controller.dto.TicketDto;
import com.denysenko.ticketcontrol.entity.Ticket;
import com.denysenko.ticketcontrol.repository.TicketRepository;
import com.denysenko.ticketcontrol.resource.PaymentResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static com.denysenko.ticketcontrol.entity.TicketStatus.ACTIVE;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TicketControlService {

    private final RouteService routeService;
    private final PaymentResource paymentResource;
    private final TicketRepository ticketRepository;

    public Mono<Ticket> saveTicket(TicketDto ticketDto) {
        log.debug("saveTicket {}", ticketDto);

        Ticket.TicketBuilder ticketBuilder = Ticket.builder()
                                                   .clientId(ticketDto.getClient().getId())
                                                   .routeId(ticketDto.getRouteId())
                                                   .status(ACTIVE.getStatusIndex());

        return routeService.getRouteById(ticketDto.getRouteId())
                           .flatMap(r -> paymentResource.createPayment(ticketDto.getClient(), r.getPrice()))
                           .doOnNext(pid -> log.debug("payment id: {}", pid))
                           .map(ticketBuilder::paymentId)
                           .doOnNext(pid -> log.debug("ticket to save: {}", ticketBuilder.build()))
                           .then(routeService.reduceTickets(ticketDto.getRouteId(), 1))
                           .flatMap(pid -> ticketRepository.save(ticketBuilder.build()));
    }

    public Mono<Ticket> getTicketById(UUID routeId) {
        return ticketRepository.findById(routeId);
    }

    public Flux<Ticket> getTicketsByPaymentIds(List<UUID> paymentIds) {
        return ticketRepository.getTicketsByPaymentsIds(paymentIds);
    }

}

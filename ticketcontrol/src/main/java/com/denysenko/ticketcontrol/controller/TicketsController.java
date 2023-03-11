package com.denysenko.ticketcontrol.controller;

import com.denysenko.ticketcontrol.controller.dto.TicketDto;
import com.denysenko.ticketcontrol.entity.Ticket;
import com.denysenko.ticketcontrol.mapper.mapstruct.TicketMapper;
import com.denysenko.ticketcontrol.service.TicketControlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@Slf4j
@Controller
@ResponseBody
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@RequestMapping(value = "/tickets")
public class TicketsController {

    private final TicketControlService ticketService;
    private final TicketMapper mapper;

    @PostMapping(path = "/ticket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Map<String, UUID>>> saveTicket(@Validated @RequestBody TicketDto ticket) {
        log.debug("{}", ticket);
        return ticketService.saveTicket(ticket)
                            .doOnNext(t -> log.debug("saved ticket from service: {}", t))
                            .defaultIfEmpty(Ticket.builder().build())
                            .map(t -> ResponseEntity.ok(Map.of("id", t.getId())));
    }

    @GetMapping("/ticket/{id}")
    public Mono<TicketDto> getTicketById(@Validated @NonNull @PathVariable UUID id) {
        return ticketService.getTicketById(id)
                            .map(mapper::toTicketDto);
    }

}

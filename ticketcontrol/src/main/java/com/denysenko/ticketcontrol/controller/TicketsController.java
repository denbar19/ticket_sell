package com.denysenko.ticketcontrol.controller;

import com.denysenko.ticketcontrol.controller.dto.TicketDto;
import com.denysenko.ticketcontrol.mapper.mapstruct.TicketMapper;
import com.denysenko.ticketcontrol.service.TicketControlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
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
    public Mono<TicketDto> saveTicket(@Valid @RequestBody TicketDto ticket) {
        log.debug("{}", ticket);
        return ticketService.saveTicket(ticket)
                            .map(mapper::toTicketDto);
    }

    @GetMapping("/ticket/{id}")
    public Mono<TicketDto> getTicketById(@Valid @NonNull @PathVariable UUID id) {
        return ticketService.getTicketById(id)
                            .map(mapper::toTicketDto);
    }

}

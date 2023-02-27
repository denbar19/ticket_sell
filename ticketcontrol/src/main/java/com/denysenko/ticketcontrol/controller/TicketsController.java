package com.denysenko.ticketcontrol.controller;

import com.denysenko.ticketcontrol.mapper.mapstruct.TicketMapper;
import com.denysenko.ticketcontrol.service.TicketControlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@Controller
@ResponseBody
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@RequestMapping(value = "/tickets")
public class TicketsController {

    private final TicketControlService ticketService;

    private final TicketMapper mapper;


    @PostMapping(path = "/ticket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TicketDto saveTicket(@Valid @RequestBody TicketDto ticket) {
        log.info("{}", ticket);
        return mapper.toTicketDto(ticketService.saveTicket(ticket));
    }

    /*@PostMapping(path = "/ticket/1")
    public int saveTicket1() {
        log.info("{}", 1);
        return 1;
    }*/

    @GetMapping("/ticket/{id}")
    public Mono<TicketDto> getTicketById(@PathVariable String id) {
        return ticketService.getTicketById(id)
                            .map(mapper::toTicketDto);
    }

}

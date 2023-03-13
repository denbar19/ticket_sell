package com.denysenko.ticketcontrol.controller;


import com.denysenko.ticketcontrol.controller.dto.ClientDto;
import com.denysenko.ticketcontrol.mapper.mapstruct.ClientMapper;
import com.denysenko.ticketcontrol.service.ClientService;
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
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @PostMapping(value = "/client", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ClientDto> createClient(@Validated @NonNull @RequestBody ClientDto client) {
        return clientService.createClient(clientMapper.toClient(client))
                            .map(clientMapper::toClientDto);
    }

    @GetMapping("/client/{clientId}")
    public Mono<ClientDto> getClientById(@Validated @NonNull @PathVariable UUID clientId) {
        return clientService.getClientById(clientId)
                            .map(clientMapper::toClientDto);
    }
}

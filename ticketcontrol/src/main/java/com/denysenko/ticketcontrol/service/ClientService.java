package com.denysenko.ticketcontrol.service;

import com.denysenko.ticketcontrol.entity.Client;
import com.denysenko.ticketcontrol.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ClientService {

    private final ClientRepository clientRepository;

    public Mono<Client> createClient(Client client) {
        return clientRepository.save(client);
    }

    public Mono<Client> getClientById(UUID clientId) {
        return clientRepository.findById(clientId);
    }
}

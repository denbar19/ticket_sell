package com.denysenko.ticketcontrol.service;

import com.denysenko.ticketcontrol.entity.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    //ClientRepository;

    public Optional<String> getClientId(Client client) {
        return Optional.empty();
    }

    public Optional<Client> getClientById() {
        return Optional.empty();
    }
}

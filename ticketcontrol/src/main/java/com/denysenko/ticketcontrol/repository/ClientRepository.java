package com.denysenko.ticketcontrol.repository;

import com.denysenko.ticketcontrol.entity.Client;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.UUID;

public interface ClientRepository extends R2dbcRepository<Client, UUID> {

}

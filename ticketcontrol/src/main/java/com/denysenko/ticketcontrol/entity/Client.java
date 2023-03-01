package com.denysenko.ticketcontrol.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table(name = "client", schema = "ticket_sell")
@Data
public class Client {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @NotNull
    @Column(name = "middle_name", nullable = false)
    private String middleName;
}

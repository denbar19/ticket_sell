package com.denysenko.ticketcontrol.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table(name = "client", schema = "ticket_sell")
@Data
public class Client implements Persistable {

    @Id
    private UUID id;
    @NotNull
    @Column
    private String firstName;
    @NotNull
    @Column
    private String lastName;
    @NotNull
    @Column
    private String middleName;

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}

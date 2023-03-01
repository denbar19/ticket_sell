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
public class Client implements Persistable<UUID> {

    @Id
    private UUID id;
    @NotNull
    @Column("first_name")
    private String firstName;
    @NotNull
    @Column("last_name")
    private String lastName;
    @NotNull
    @Column("middle_name")
    private String middleName;

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}

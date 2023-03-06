package com.denysenko.ticketcontrol.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import org.springframework.lang.NonNull;
import java.util.UUID;

@Table(name = "client", schema = "public")
@Data
public class Client implements Persistable<UUID> {

    @Id
    private UUID id;
    @NonNull
    @Column("first_name")
    private String firstName;
    @NonNull
    @Column("last_name")
    private String lastName;
    @NonNull
    @Column("middle_name")
    private String middleName;

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}

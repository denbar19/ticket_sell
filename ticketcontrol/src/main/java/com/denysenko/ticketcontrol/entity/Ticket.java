package com.denysenko.ticketcontrol.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;


@Table(name = "ticket", schema = "public")
@Data
@Builder
public class Ticket implements Persistable<UUID> {

    @Id
    private UUID id;
    @Column("client_id")
    private UUID clientId;
    @Column("route_id")
    private UUID routeId;
    @Column("status")
    private Short status;
    @Column("payment_id")
    private UUID paymentId;

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}

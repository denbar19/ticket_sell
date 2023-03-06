package com.denysenko.payment.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "payment", schema = "public")
@Data
@Builder
public class Payment implements Persistable<UUID> {

    @Id
    @Column("id")
    private UUID id;
    @Column("amount")
    private Float amount;
    @NonNull
    @Column("status")
    private Short status;
    @NonNull
    @Column("checked")
    private Boolean checked;
    @Column("created_date")
    private LocalDateTime createdDate;
    @Column("updated_date")
    private LocalDateTime updatedDate;

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}

package com.denysenko.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "payment", schema = "ticket_sell")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Payment {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "amount", nullable = false)
    private Float amount;
    @NotNull
    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT NOT NULL")
    private short status;
    @NotNull
    @Column(name = "checked", nullable = false)
    private boolean checked;
    @NotNull
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @NotNull
    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate;

}

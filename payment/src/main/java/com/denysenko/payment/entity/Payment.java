package com.denysenko.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "payment", schema = "ticket_sell")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Payment {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "amount", nullable = false)
    private Float amount;
    @NonNull
    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT NOT NULL")
    private Short status;
    @NonNull
    @Column(name = "checked", nullable = false)
    private Boolean checked;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate;

}

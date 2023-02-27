package com.denysenko.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table("payment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(6) NOT NULL")
    private PaymentStatus status;
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
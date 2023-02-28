package com.denysenko.payment.persistanse;

import com.denysenko.payment.Payment;
import com.denysenko.payment.PaymentStatus;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface PaymentRepository extends R2dbcRepository<Payment, String> {

    @Query("SELECT status FROM payment WHERE id = :paymentId")
    Mono<Short> getPaymentStatus(UUID paymentId);

    @Query("SELECT id FROM payment WHERE status = :status AND checked = :checked")
    Flux<String> getPaymentIdsByStatus(short status, boolean checked);
}

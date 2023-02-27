package com.denysenko.payment;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentRepository extends R2dbcRepository<Payment, String> {

    @Query("SELECT status FROM payment WHERE id = :paymentId")
    Mono<PaymentStatus> getPaymentStatus(String paymentId);

    @Query("SELECT id FROM payment WHERE status = :status AND checked = :checked")
    Flux<String> getPaymentIdsByStatus(PaymentStatus status, boolean checked);
}

package com.denysenko.payment;

import com.denysenko.payment.entity.Payment;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PaymentRepository extends R2dbcRepository<Payment, UUID> {

    @Query("SELECT status FROM public.payment WHERE id = :paymentId")
    Mono<Short> getPaymentStatus(UUID paymentId);

    @Query("SELECT id FROM public.payment WHERE status = :status AND checked = :checked")
    Flux<String> getPaymentIdsByStatus(Short status, Boolean checked);
}

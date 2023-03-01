package com.denysenko.payment;

import com.denysenko.payment.entity.Payment;
import com.denysenko.payment.service.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class PaymentRepositoryTest {
    private PaymentRepository paymentRepository;

    public PaymentRepositoryTest(@Autowired PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Test
    void getPaymentStatus() {
        UUID uuid = UUID.randomUUID();
        Mono<Payment> save = this.paymentRepository.save(Payment.builder()
                                                                .id(uuid)
                                                                .amount(0.0F)
                                                                .status(PaymentStatus.NEW.getStatusIndex())
                                                                .checked(false)
                                                                .createdDate(LocalDateTime.now())
                                                                .createdDate(LocalDateTime.now())
                                                                .build());

        this.paymentRepository.getPaymentStatus(uuid);
        StepVerifier.create(save)
                    .expectNextCount(1)
                    .verifyComplete();
    }



    @Test
    void getPaymentIdsByStatus() {
    }
}
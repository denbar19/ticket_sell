package com.denysenko.payment.service;

import com.denysenko.payment.entity.Payment;
import com.denysenko.payment.entity.PaymentDto;
import com.denysenko.payment.PaymentRepository;
import com.denysenko.payment.entity.PaymentStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import static com.denysenko.payment.entity.PaymentStatus.FAILED;
import static com.denysenko.payment.entity.PaymentStatus.NEW;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class PaymentService {

    private static final boolean UNCHECKED = false;

    private final PaymentRepository paymentRepository;

    public Mono<Payment> createPayment(PaymentDto paymentDto) {
        log.debug("createPayment: {}", paymentDto);
        // TODO create or check client, but in ticket service the same
        // maybe another microservice

        var random = new Random();
        Payment payment = Payment.builder()
                                 .amount(paymentDto.getAmount())
                                 // set random status to return random by task description
                                 .status((short) random.nextInt(PaymentStatus.values().length))
                                 .checked(UNCHECKED)
                                 .createdDate(LocalDateTime.now())
                                 //.updatedDate(LocalDateTime.now())
                                 .build();
        return paymentRepository.save(payment);
    }

    public Mono<Payment> getPaymentById(UUID paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public Flux<String> getNewPaymentsIds() {
        return paymentRepository.getPaymentIdsByStatus(NEW.getStatusIndex(), UNCHECKED);
    }

    public Flux<String> getFailedPaymentsIds() {
        return paymentRepository.getPaymentIdsByStatus(FAILED.getStatusIndex(), UNCHECKED);
    }

}

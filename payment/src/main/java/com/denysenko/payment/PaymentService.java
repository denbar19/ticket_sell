package com.denysenko.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import static com.denysenko.payment.PaymentStatus.FAILED;
import static com.denysenko.payment.PaymentStatus.NEW;

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
        PaymentStatus[] array = PaymentStatus.values();
        Payment payment = Payment.builder()
                                 .id(UUID.randomUUID())
                                 .amount(paymentDto.getAmount())
                                 // set random status to return random by task description
                                 .status(array[random.nextInt(array.length)])
                                 .checked(UNCHECKED)
                                 .createdDate(LocalDateTime.now())
                                 //.updatedDate(LocalDateTime.now())
                                 .build();
        Mono<Payment> save = paymentRepository.save(payment);
//        save.subscribe(p -> log.info("{}", p));
        return save;
    }

    public Flux<String> getNewPaymentsIds() {
        return paymentRepository.getPaymentIdsByStatus(NEW, UNCHECKED);
    }

    public Flux<String> getFailedPaymentsIds() {
        return paymentRepository.getPaymentIdsByStatus(FAILED, UNCHECKED);
    }

}

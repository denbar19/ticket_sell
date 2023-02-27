package com.denysenko.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class PaymentStatusService {

    private final PaymentRepository paymentRepository;

    public Mono<PaymentStatus> getPaymentStatus(String paymentId) {
        return paymentRepository.getPaymentStatus(paymentId);
    }

    // random status if use without db
    /*public PaymentStatus getPaymentStatus(UUID paymentId) {
        var random = new Random();
        PaymentStatus[] array = PaymentStatus.values();
        return array[random.nextInt(array.length)];
    }*/
}

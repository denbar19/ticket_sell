package com.denysenko.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public String createPayment(Credentials credentials, float amount) {
        log.debug("PaymentService: {}, {}", credentials, amount);
        // create or check client, but in ticket service the same
        var random = new Random();
        PaymentStatus[] array = PaymentStatus.values();
        return paymentRepository.save(Payment.builder()
                                             // set random status to return random by task description
                                             .status(array[random.nextInt(array.length)])
                                             .checked(false)
                                             .build())
                                .block().getId().toString();
    }

    public Flux<String> getNewPaymentsIds() {
        return paymentRepository.getPaymentIdsByStatus(NEW, UNCHECKED);
    }

    public Flux<String> getFailedPaymentsIds() {
        return paymentRepository.getPaymentIdsByStatus(FAILED, UNCHECKED);
    }

}

package com.denysenko.payment.service;

import com.denysenko.payment.PaymentRepository;
import com.denysenko.payment.entity.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class PaymentStatusService {

    private final PaymentRepository paymentRepository;

    public Mono<PaymentStatus> getPaymentStatus(UUID paymentId) {
        return paymentRepository.getPaymentStatus(paymentId)
                                .map(PaymentStatus::getStatus);
    }

}

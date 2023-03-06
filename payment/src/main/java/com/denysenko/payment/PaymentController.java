package com.denysenko.payment;

import com.denysenko.payment.entity.PaymentDto;
import com.denysenko.payment.entity.PaymentStatus;
import com.denysenko.payment.service.PaymentService;
import com.denysenko.payment.service.PaymentStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@ResponseBody
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@RequestMapping(value = "/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentStatusService paymentStatusService;

    private final PaymentMapper mapper;

    @PostMapping("/payment")
    public Mono<UUID> createPayment(@Valid @NonNull @RequestBody PaymentDto paymentDto) {
        return paymentService.createPayment(paymentDto)
                             .doOnNext(p -> log.debug("createPayment: {}", p))
                             .flatMap(p -> Mono.justOrEmpty(p.getId()));
    }

    @GetMapping("/payment/{paymentId}")
    public Mono<PaymentDto> getPayment(@Valid @NonNull @PathVariable UUID paymentId) {
        return paymentService.getPaymentById(paymentId)
                             .map(mapper::toPaymentDto);
    }

    @GetMapping("/payment/{paymentId}/status")
    public Mono<String> getPaymentStatusByPaymentId(@Valid @NonNull @PathVariable UUID paymentId) {
        return paymentStatusService.getPaymentStatus(paymentId)
                                   .map(PaymentStatus::toString);
    }

    @GetMapping("/status/new")
    public Mono<List<String>> getNewPaymentsIds() {
        return paymentService.getNewPaymentsIds().collectList();
    }

    @GetMapping("/status/failed")
    public Mono<List<String>> getFailedPaymentsIds() {
        return paymentService.getFailedPaymentsIds().collectList();
    }
}

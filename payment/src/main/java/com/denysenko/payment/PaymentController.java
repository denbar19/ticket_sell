package com.denysenko.payment;

import com.denysenko.payment.entity.PaymentDto;
import com.denysenko.payment.service.PaymentService;
import com.denysenko.payment.service.PaymentStatus;
import com.denysenko.payment.service.PaymentStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
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

    @PostMapping("/payment")
    public Mono<UUID> createPayment(@NotNull @RequestBody Mono<PaymentDto> paymentDto) {
        return paymentDto.flatMap(paymentService::createPayment)
                         .doOnNext(p -> log.info("createPayment: {}", p))
                         .flatMap(p -> Mono.justOrEmpty(p.getId()));
    }

    @GetMapping("/payment/{paymentId}/status")
    public Mono<String> getPaymentStatusByPaymentId(@NotNull @PathVariable UUID paymentId) {
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

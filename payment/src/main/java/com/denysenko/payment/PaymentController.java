package com.denysenko.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;

@Slf4j
@Controller
@ResponseBody
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@RequestMapping(value = "/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentStatusService paymentStatusService;

    private final CredentialsMapper mapper;

    @PostMapping("/payment")
    public Mono<Long> createPayment(@NotNull @RequestBody Mono<PaymentDto> paymentDto) {
        //paymentDto.subscribe(p -> System.out.println(("PaymentController.createPayment: " + p)));

        return paymentDto.flatMap(paymentService::createPayment)
                         .doOnNext(p -> log.info("{}", p))
                         .flatMap(p -> Mono.justOrEmpty(p.getId()));
    }

    @GetMapping("/payment/{paymentId}/status")
    public Mono<PaymentStatus> getNewPaymentsIds(@NotNull @PathVariable String paymentId) {
        return paymentStatusService.getPaymentStatus(paymentId);
    }

    @GetMapping("/new")
    public Flux<String> getNewPaymentsIds() {
        return paymentService.getNewPaymentsIds();
    }

    @GetMapping("/failed")
    public Flux<String> getFailedPaymentsIds() {
        return paymentService.getFailedPaymentsIds();
    }
}

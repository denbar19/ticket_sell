package com.denysenko.ticketcontrol.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentResource {

    private static final MediaType JSON = MediaType.APPLICATION_JSON;

    // Http async call
    private final WebClient webClient = WebClient.create("http://localhost:8080/payments/");

    public String createPayment(float price) {
        return webClient.post()
                        .uri("payment")
                        .accept(JSON)
                        .bodyValue(price)
                        .exchangeToMono(res -> {
                            if (res.statusCode().equals(HttpStatus.OK)) {
                                return res.bodyToMono(String.class);
                            } else {
                                return res.createError();
                            }
                        }).block();
    }

    public PaymentStatus getPaymentStatus(String ticketId) {
        return webClient.get()
                        .uri("payment/status/" + ticketId)
                        .accept(JSON)
                        .exchangeToMono(res -> {
                            if (res.statusCode().equals(HttpStatus.OK)) {
                                return res.bodyToMono(PaymentStatus.class);
                            } else {
                                return res.createError();
                            }
                        }).block();
    }

    public void getNewPayments() {

    }

    public List<String> getFailedPaymentsIds() {
        return webClient.get().uri("failed")
                        .accept(JSON)
                        .retrieve()
                        .bodyToFlux(String.class)
                        .collectList()
                        .block();
    }
}
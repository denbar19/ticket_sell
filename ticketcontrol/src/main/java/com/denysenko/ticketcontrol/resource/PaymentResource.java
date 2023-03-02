package com.denysenko.ticketcontrol.resource;

import com.denysenko.ticketcontrol.controller.dto.ClientDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class PaymentResource {

    private static final MediaType JSON = MediaType.APPLICATION_JSON;

    // Uri Paths
    private static final String PAYMENT_SERVICE_HOST = "http://localhost:8080/payments";
    private static final String SLASH = "/";
    private static final String PAYMENT = "/payment";
    private static final String STATUS = "/status";
    private static final String NEW = "/new";
    private static final String FAILED = "/failed";

    // Json Keys
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String MIDDLE_NAME = "middleName";
    private static final String AMOUNT = "amount";

    private final WebClient webClient = WebClient.create(PAYMENT_SERVICE_HOST);

    public Mono<UUID> createPayment(ClientDto clientDto, float price) {
        log.debug("create payment price: {}, {}", price, clientDto);
        return webClient.post()
                        .uri(PAYMENT)
                        .accept(JSON)
                        .bodyValue(Map.of(FIRST_NAME, clientDto.getFirstName(),
                                          LAST_NAME, clientDto.getLastName(),
                                          MIDDLE_NAME, clientDto.getMiddleName(),
                                          AMOUNT, price))
                        .exchangeToMono(res -> {
                            if (res.statusCode().equals(HttpStatus.OK)) {
                                return res.bodyToMono(UUID.class);
                            } else {
                                return res.createError();
                            }
                        });
    }

    public PaymentStatus getPaymentStatus(UUID ticketId) {
        return webClient.get()
                        .uri(PAYMENT + STATUS + SLASH + ticketId.toString())
                        .accept(JSON)
                        .exchangeToMono(res -> {
                            if (res.statusCode().equals(HttpStatus.OK)) {
                                return res.bodyToMono(PaymentStatus.class);
                            } else {
                                return res.createError();
                            }
                        }).block();
    }

    public List<UUID> getNewPaymentsIds() {
        return webClient.get()
                        .uri(STATUS + NEW)
                        .retrieve()
                        .bodyToFlux(UUID.class)
                        .collectList()
                        .block();
    }

    public List<UUID> getFailedPaymentsIds() {
        return webClient.get()
                        .uri(STATUS + FAILED)
                        .retrieve()
                        .bodyToFlux(UUID.class)
                        .collectList()
                        .block();
    }
}
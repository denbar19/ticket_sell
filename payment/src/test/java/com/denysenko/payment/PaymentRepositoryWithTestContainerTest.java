package com.denysenko.payment;

import com.denysenko.payment.entity.Payment;
import com.denysenko.payment.entity.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.PostgreSQLR2DBCDatabaseContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration
@TestMethodOrder(MethodOrderer.DisplayName.class)
class PaymentRepositoryWithTestContainerTest {

    //@Container
    //static PostgreSQLR2DBCDatabaseContainer container;

    @Container
    private static PostgreSQLContainer<?> postgresqlContainer =
            (PostgreSQLContainer<?>) new PostgreSQLContainer("postgres:9.6.8")
            .withDatabaseName("ticket_sell_test")
            .withUsername("admin")
            .withPassword("admin")
            .withReuse(true);

    @BeforeClass
    void test() {
        assertThat(postgresqlContainer.isRunning()).isTrue();
    }

    private PaymentRepository paymentRepository;

    public PaymentRepositoryWithTestContainerTest(@Autowired PostgreSQLR2DBCDatabaseContainer container,
                                                  @Autowired PaymentRepository paymentRepository) {
//        this.container = container;
        this.paymentRepository = paymentRepository;
    }

    //@Test
    void getPaymentStatus() {
        UUID uuid = UUID.randomUUID();

        Mono<Payment> save = this.paymentRepository.save(Payment.builder()
                                                                .id(uuid)
                                                                .amount(0.0F)
                                                                .status(PaymentStatus.NEW.getStatusIndex())
                                                                .checked(false)
                                                                .createdDate(LocalDateTime.now())
                                                                .createdDate(LocalDateTime.now())
                                                                .build());
        //.subscribe(p -> log.info("{}", p));
        this.paymentRepository.getPaymentStatus(uuid);
        StepVerifier.create(save)
                    .expectNextCount(1)
                    .verifyComplete();
    }



    //@Test
    void getPaymentIdsByStatus() {
    }
}
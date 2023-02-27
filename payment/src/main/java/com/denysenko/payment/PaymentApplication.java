package com.denysenko.payment;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.TimeZone;

@SpringBootApplication
@EnableR2dbcRepositories
public class PaymentApplication {

    private static final String UTC = "UTC";
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone(UTC));
    }
}

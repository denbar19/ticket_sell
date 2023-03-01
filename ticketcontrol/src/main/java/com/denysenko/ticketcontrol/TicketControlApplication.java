package com.denysenko.ticketcontrol;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
@EnableR2dbcRepositories
public class TicketControlApplication {

    private static final String UTC = "UTC";

    public static void main(String[] args) {
        SpringApplication.run(TicketControlApplication.class, args);
    }

    // to sync timezone with postgres
    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone(UTC));
    }
}

package com.denysenko.ticketcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableR2dbcRepositories
public class TicketControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketControlApplication.class, args);
    }

}

package com.denysenko.ticketcontrol;

import io.r2dbc.spi.ConnectionFactory;
import jakarta.annotation.PostConstruct;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@SpringBootApplication
//@EnableScheduling
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

    @Bean
    public ConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config =
                PostgresqlConnectionConfiguration.builder()
                                                 .database("ticket_sell")
                                                 .username("admin")
                                                 .password("admin")
                                                 .host("localhost")
                                                 .port(15432)
                                                 .schema("public")
                                                 .build();

        return new PostgresqlConnectionFactory(config);
    }
}

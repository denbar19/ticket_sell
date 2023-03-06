package com.denysenko.payment;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.TimeZone;

@SpringBootApplication
@EnableR2dbcRepositories
public class PaymentApplication {

    private static final String UTC = "UTC";
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    // to sync timezone with postgres
    @PostConstruct
    public void init(){
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
                                                     .database("ticket_sell")
                                                     .schema("public")
                                                     .build();

            return new PostgresqlConnectionFactory(config);
    }

}

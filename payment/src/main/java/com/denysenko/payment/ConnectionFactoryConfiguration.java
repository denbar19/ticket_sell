package com.denysenko.payment;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionFactoryConfiguration {

    @Bean
    ConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config =
                PostgresqlConnectionConfiguration.builder()
                                                 .database("ticket_sell")
                                                 .username("admin")
                                                 .password("admin")
                                                 .host("localhost").schema("ticket_sell")
                                                 .port(15432)
                                                 .build();
        return new PostgresqlConnectionFactory(config);
    }

}

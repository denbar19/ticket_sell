package com.denysenko.payment.testcontainer;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import static java.lang.String.format;

public abstract class PostgresR2dbcTestContainer {

    private static final PostgreSQLContainer<?> postgresContainer =
            new PostgreSQLContainer<>("postgres:9.6.8")
                    .withDatabaseName("ticket_sell_test")
                    .withUsername("admin")
                    .withPassword("admin");

    static {
        postgresContainer.start();
    }

    @DynamicPropertySource
    private static void setDatasourceProperties(DynamicPropertyRegistry registry) {

        // JDBC DataSource Example
        /*registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
        registry.add("spring.datasource.username", postgresContainer::getUsername);*/

        // R2DBC DataSource Example
        registry.add("spring.r2dbc.url", () ->
                format("r2dbc:pool:postgresql://%s:%d/%s",
                       postgresContainer.getHost(),
                       postgresContainer.getFirstMappedPort(),
                       postgresContainer.getDatabaseName()));
        registry.add("spring.r2dbc.username", postgresContainer::getUsername);
        registry.add("spring.r2dbc.password", postgresContainer::getPassword);
    }
}
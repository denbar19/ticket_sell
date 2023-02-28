package com.denysenko.payment.persistanse.config;

import com.denysenko.payment.PaymentStatus;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.postgresql.codec.EnumCodec;
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
                                                 /*.codecRegistrar(EnumCodec.builder()
                                                                          .withEnum("payment_status",
                                                                                    PaymentStatus.class)
                                                                          .build())*/
                                                 .build();

//        R2dbcDialect dialect = PostgresDialect.INSTANCE;
//        DefaultReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(dialect, Collections.singletonList(new PaymentStatusTypeConverter()));
//
//        DatabaseClient databaseClient = DatabaseClient.builder()
//                                                      .connectionFactory(new PostgresqlConnectionFactory(configuration))
//                                                      .dataAccessStrategy(strategy)
//                                                      .build();

        return new PostgresqlConnectionFactory(config);
    }

}

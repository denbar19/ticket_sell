package com.denysenko.payment.persistanse.config;

import com.denysenko.payment.persistanse.converter.*;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.List;

//@Configuration
//@EnableR2dbcRepositories
public class R2dbcConfiguration //extends AbstractR2dbcConfiguration
 {

    /*private final ConnectionFactory connectionFactory;

    public R2dbcConfiguration(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }*/

    /*@Override
    public ConnectionFactory connectionFactory() {
        return this.connectionFactory;
    }*/

    // Some r2dbc method doesn't recognize custom PaymentStatus enum
//    @Override
//    protected List<Object> getCustomConverters() {
//        return List.of(new PaymentStatusIntReaderConverter(),
//                       //new PaymentStatusReaderConverter(),
//                       new PaymentStatusWriterConverter(),
//                       new PaymentStatusConverter()
////                       new PaymentStatusWriterFromShortConverter()
//        );
//    }
}

package com.denysenko.payment.persistanse.config;

import com.denysenko.payment.persistanse.converter.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.DialectResolver;
import org.springframework.data.r2dbc.dialect.PostgresDialect;
import org.springframework.data.r2dbc.dialect.R2dbcDialect;
import org.springframework.r2dbc.core.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

//@Configuration
//@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class R2dbcConvertorsConfig {

    //private final DatabaseClient databaseClient;

//    @Bean
//    public R2dbcCustomConversions customConversions() {
//        R2dbcDialect dialect = DialectResolver.getDialect(this.databaseClient.getConnectionFactory());
//        List<Converter<?, ?>> converters = new ArrayList<>();
//        converters.add(new PaymentStatusConverter());
////        converters.add(new PaymentStatusIntReaderConverter());
////        converters.add(new PaymentStatusReaderConverter());
////        converters.add(new PaymentStatusWriterConverter());
//        //converters.add(new PaymentStatusWriterFromShortConverter());
//        //converters.addAll(dialect.getConverters());
//        dialect.getConverters().forEach(o -> converters.add((Converter<?, ?>) o));
//        return R2dbcCustomConversions.of(dialect, converters);
//    }
}

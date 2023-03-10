module com.denysenko.payment {
    requires spring.core;
    requires spring.boot;
    requires spring.beans;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.data.commons;
    requires spring.data.r2dbc;
    requires spring.data.relational;
    requires reactor.core;
    requires r2dbc.postgresql;
    requires r2dbc.spi;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires lombok;
    requires org.mapstruct;
    requires org.slf4j;
    requires java.sql;

    exports com.denysenko.payment;
    exports com.denysenko.payment.service to spring.beans;
    exports com.denysenko.payment.entity to spring.data.commons;

    opens com.denysenko.payment to spring.core;
    opens com.denysenko.payment.entity to spring.core, com.fasterxml.jackson.databind;
}
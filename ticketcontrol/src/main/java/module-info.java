module ticketcontrol {
    requires spring.core;
    requires spring.boot;
    requires spring.beans;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.data.commons;
    requires spring.data.r2dbc;
    requires spring.data.relational;
    requires spring.webflux;
    requires reactor.core;
    requires r2dbc.postgresql;
    requires r2dbc.spi;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires lombok;
    requires org.mapstruct;
    requires org.slf4j;
    requires java.validation;
    requires spring.r2dbc;
}
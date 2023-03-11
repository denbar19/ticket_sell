module ticketcontrol {
    requires spring.core;
    requires spring.boot;
    requires spring.beans;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.data.commons;
    requires spring.data.r2dbc;
    requires spring.r2dbc;
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
    requires jakarta.validation;
    requires java.sql;

    exports com.denysenko.ticketcontrol;
    exports com.denysenko.ticketcontrol.controller to spring.beans, spring.webflux;
    exports com.denysenko.ticketcontrol.entity to spring.beans, spring.data.commons;
    exports com.denysenko.ticketcontrol.mapper.mapstruct to spring.beans;
    exports com.denysenko.ticketcontrol.resource to spring.beans;
    exports com.denysenko.ticketcontrol.service to spring.beans;

    opens com.denysenko.ticketcontrol;
    opens com.denysenko.ticketcontrol.entity to spring.core;
    opens com.denysenko.ticketcontrol.controller.dto to com.fasterxml.jackson.databind;
}
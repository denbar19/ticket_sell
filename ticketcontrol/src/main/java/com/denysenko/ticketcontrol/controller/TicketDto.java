package com.denysenko.ticketcontrol.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
public class TicketDto {

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    @JsonProperty
    private String routeId;
    //@NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    //@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
    @JsonProperty//("client")
    private ClientDto client;

}

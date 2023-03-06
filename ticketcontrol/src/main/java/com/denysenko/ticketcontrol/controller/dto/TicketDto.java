package com.denysenko.ticketcontrol.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Builder
public class TicketDto {

    @NotBlank
    @JsonProperty
    private UUID routeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonProperty
    private ClientDto client;

}

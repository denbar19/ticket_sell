package com.denysenko.ticketcontrol.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
@JsonSerialize
public class TicketDto {

    @NotBlank
    //@JsonProperty
    private UUID routeId;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    //@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
    //@JsonProperty
    private ClientDto client;

}

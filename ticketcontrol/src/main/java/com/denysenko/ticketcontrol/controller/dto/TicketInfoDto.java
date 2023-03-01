package com.denysenko.ticketcontrol.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonSerialize
public class TicketInfoDto {

    private RouteDto route;
    private PaymentDto payment;
}

package com.denysenko.ticketcontrol.entity;

import com.denysenko.ticketcontrol.resource.PaymentStatus;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonSerialize
public class TicketInfo {

    private Route route;
    private PaymentStatus paymentStatus;
}

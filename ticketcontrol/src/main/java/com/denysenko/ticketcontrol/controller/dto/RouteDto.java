package com.denysenko.ticketcontrol.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonSerialize
public class RouteDto {

    private long id;
    private String identity;
    private String departureStation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime departureDate;
    private long price;
    private int available_seats;

}

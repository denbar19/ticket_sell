package com.denysenko.ticketcontrol.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RouteDto {

    @JsonProperty
    private UUID id;
    @NotBlank
    @Size(min = 2, max = 10)
    @JsonProperty
    private String identity;
    @NotBlank
    @Size(min = 2, max = 100)
    @JsonProperty
    private String departureStation;
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonProperty
    private LocalDateTime departureDate;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    @JsonProperty
    private Long price;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    @JsonProperty
    private Integer availableSeats;

}

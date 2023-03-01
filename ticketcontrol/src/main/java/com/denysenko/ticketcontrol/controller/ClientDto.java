package com.denysenko.ticketcontrol.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@JsonSerialize
public class ClientDto {

    private UUID id;
    //@NotBlank
    //@Size(min = 2, max = 100)
    //@JsonProperty
    private String firstName;
    //@NotBlank
    //@Size(min = 2, max = 100)
    //@JsonProperty
    private String lastName;
    //@NotBlank
    //@Size(min = 2, max = 100)
    //@JsonProperty
    private String middleName;

}

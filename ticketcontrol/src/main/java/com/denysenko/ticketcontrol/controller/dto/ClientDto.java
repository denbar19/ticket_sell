package com.denysenko.ticketcontrol.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class ClientDto {

    @JsonProperty
    private UUID id;
    @NotBlank
    @Size(min = 2, max = 100)
    @JsonProperty
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 100)
    @JsonProperty
    private String lastName;
    @NotBlank
    @Size(min = 2, max = 100)
    @JsonProperty
    private String middleName;

}

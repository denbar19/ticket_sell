package com.denysenko.ticketcontrol.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

package com.denysenko.ticketcontrol.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder(toBuilder = true)
//@NoArgsConstructor
//@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDto {

    //@NotBlank
    //@Size(min = 2, max = 100)
    @JsonProperty
    private String firstName;
    //@NotBlank
    //@Size(min = 2, max = 100)
    @JsonProperty
    private String lastName;
    //@NotBlank
    //@Size(min = 2, max = 100)
    @JsonProperty
    private String middleName;

}

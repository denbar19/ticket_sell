package com.denysenko.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentDto {
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String middleName;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    @JsonProperty
    private float amount;
}

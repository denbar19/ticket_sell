package com.denysenko.payment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String middleName;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    @JsonProperty
    private Float amount;
}

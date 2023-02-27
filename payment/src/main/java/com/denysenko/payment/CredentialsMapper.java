package com.denysenko.payment;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CredentialsMapper {

    PaymentDto toCredentialsDto(Credentials credentials);

    Credentials toCredentials(PaymentDto paymentDto);
}

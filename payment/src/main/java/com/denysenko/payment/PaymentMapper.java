package com.denysenko.payment;

import com.denysenko.payment.entity.Payment;
import com.denysenko.payment.entity.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {


    PaymentDto toPaymentDto(Payment payment);

    Payment toPayment(PaymentDto paymentDto);
}

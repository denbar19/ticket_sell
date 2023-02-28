package com.denysenko.payment.persistanse.converter;

import com.denysenko.payment.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.lang.NonNull;

@Slf4j
@ReadingConverter
@AllArgsConstructor
public class PaymentStatusReaderConverter implements Converter<String, PaymentStatus> {

    @Override
    public PaymentStatus convert(@NonNull String targetStatus) {
        return PaymentStatus.valueOf(targetStatus);
    }
}
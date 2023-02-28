package com.denysenko.payment.persistanse.converter;

import com.denysenko.payment.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.lang.NonNull;

@Slf4j
@WritingConverter
@AllArgsConstructor
public class PaymentStatusConverter implements Converter<PaymentStatus, Short> {

    @Override
    public Short convert(@NonNull PaymentStatus source) {
        return source.getStatusIndex();
    }
}

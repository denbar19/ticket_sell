package com.denysenko.payment.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.NoSuchElementException;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum PaymentStatus {
    NEW(0),
    DONE(1),
    FAILED(2);

    private final short statusIndex;

    PaymentStatus(int statusIndex) {
        this.statusIndex = (short) statusIndex;
    }

    public static PaymentStatus getStatus(short value) {
        for (PaymentStatus s : values()) {
            if (s.statusIndex == value)
                return s;
        }
        throw new NoSuchElementException();
    }

    public short getStatusIndex() {
        return statusIndex;
    }

}

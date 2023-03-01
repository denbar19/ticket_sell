package com.denysenko.ticketcontrol.entity;

import java.util.NoSuchElementException;

public enum TicketStatus {
    ACTIVE(0),
    COMPLETED(1),
    PENDING(2);

    private final short statusIndex;

    TicketStatus(int statusIndex) {
        this.statusIndex = (short) statusIndex;
    }

    public static TicketStatus getStatus(short value) {
        for (TicketStatus s : values()) {
            if (s.statusIndex == value)
                return s;
        }
        throw new NoSuchElementException();
    }

    public short getStatusIndex() {
        return statusIndex;
    }

}

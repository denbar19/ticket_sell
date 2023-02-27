package com.denysenko.ticketcontrol;

import lombok.Builder;

@Builder
public record Credentials(String firstName, String lastName, String middleName) {}

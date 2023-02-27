package com.denysenko.payment;

import lombok.Builder;

@Builder
public record Credentials(String firstName, String lastName, String middleName) {}

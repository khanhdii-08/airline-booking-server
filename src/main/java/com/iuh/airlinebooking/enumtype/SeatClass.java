package com.iuh.airlinebooking.enumtype;

import lombok.Setter;

import java.util.stream.Stream;

public enum SeatClass implements EntityPropertyEnum<String> {
    ECONOMY("ECONOMY"),
    PREMIUM_ECONOMY("PREMIUM_ECONOMY"),
    BUSINESS("BUSINESS");

    @Setter
    private String value;

    SeatClass(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public static synchronized SeatClass parseValue(String enumValue) {
        return Stream.of(SeatClass.values()).filter(c -> c.getValue().equals(enumValue)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

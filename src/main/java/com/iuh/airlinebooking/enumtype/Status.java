package com.iuh.airlinebooking.enumtype;

import lombok.Setter;

import java.util.stream.Stream;

public enum Status implements EntityPropertyEnum<String> {
    ACT("ACT"),
    PEN("PEN"),
    DEL("DEL")
    ;

    @Setter
    private String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public static synchronized Status parseValue(String enumValue) {
        return Stream.of(Status.values()).filter(c -> c.getValue().equals(enumValue)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

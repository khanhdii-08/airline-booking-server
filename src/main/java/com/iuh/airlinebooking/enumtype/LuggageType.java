package com.iuh.airlinebooking.enumtype;

import lombok.Setter;

import java.util.stream.Stream;

public enum LuggageType implements EntityPropertyEnum<String> {
    CHECKED("CHECKED"),
    CARRY_ON("CARRY_ON")
    ;

    @Setter
    private String value;

    LuggageType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public static synchronized LuggageType parseValue(String enumValue) {
        return Stream.of(LuggageType.values()).filter(c -> c.getValue().equals(enumValue)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

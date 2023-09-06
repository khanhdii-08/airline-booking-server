package com.iuh.airlinebooking.enumtype;

import lombok.Setter;

import java.util.stream.Stream;

public enum OptionType implements EntityPropertyEnum<String> {
    MEAL_OPT("MEAL_OPT"),
    BAGGAGE_OPT("BAGGAGE_OPT")
    ;

    @Setter
    private String value;

    OptionType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public static synchronized OptionType parseValue(String enumValue) {
        return Stream.of(OptionType.values()).filter(c -> c.getValue().equals(enumValue)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

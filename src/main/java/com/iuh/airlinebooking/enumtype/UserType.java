package com.iuh.airlinebooking.enumtype;

import lombok.Setter;

import java.util.stream.Stream;

public enum UserType implements EntityPropertyEnum<String>{

    ROLE_USER("ROLE_USER"),
    ROLE_EMPLOYEE("ROLE_EMPLOYEE"),
    ROLE_ADMIN("ROLE_ADMIN")
    ;

    @Setter
    private String value;

    UserType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public static synchronized UserType parseValue(String enumValue) {
        return Stream.of(UserType.values()).filter(c -> c.getValue().equals(enumValue)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

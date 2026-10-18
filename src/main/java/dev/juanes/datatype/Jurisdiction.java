package dev.juanes.datatype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Jurisdiction {
    EU("eu"),
    FEDRAMP("fedramp"),
    US("us");

    private final String value;

    Jurisdiction(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Jurisdiction fromValue(String value) {
        if (value == null)
            return null;
        return Arrays.stream(Jurisdiction.values())
                .filter(jurisdiction -> jurisdiction.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}

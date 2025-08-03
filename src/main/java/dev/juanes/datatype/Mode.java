package dev.juanes.datatype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Mode {
    AUTO("auto"),
    DISABLED("disabled");

    private final String value;

    Mode(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Mode fromValue(String value) {
        if (value == null)
            return null;
        return Arrays.stream(Mode.values())
                .filter(mode -> mode.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}

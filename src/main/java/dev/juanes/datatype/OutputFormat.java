package dev.juanes.datatype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum OutputFormat {
    POLLING("polling");

    private final String value;

    OutputFormat(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static OutputFormat fromValue(String value) {
        if (value == null)
            return null;
        return Arrays.stream(OutputFormat.values())
                .filter(output -> output.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}

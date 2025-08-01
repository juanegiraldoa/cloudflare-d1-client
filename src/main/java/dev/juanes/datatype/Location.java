package dev.juanes.datatype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Location {
    WNAM("wnam"),
    ENAM("enam"),
    WEUR("weur"),
    EEUR("eeur"),
    APAC("apac"),
    OC("oc");

    private final String value;

    Location(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Location fromValue(String value) {
        if (value == null)
            return null;
        return Arrays.stream(Location.values())
                .filter(location -> location.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}

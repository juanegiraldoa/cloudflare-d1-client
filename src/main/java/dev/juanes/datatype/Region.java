package dev.juanes.datatype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * Region reported by D1 in response metadata ({@code served_by_region}).
 */
public enum Region {
    WNAM("WNAM"),
    ENAM("ENAM"),
    WEUR("WEUR"),
    EEUR("EEUR"),
    APAC("APAC"),
    OC("OC");

    private final String value;

    Region(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Region fromValue(String value) {
        if (value == null)
            return null;
        return Arrays.stream(Region.values())
                .filter(region -> region.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}

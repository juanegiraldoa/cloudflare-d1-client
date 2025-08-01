package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timings {
    @JsonProperty("sql_duration_ms")
    private Long sqlDurationMs;

    public Long getSqlDurationMs() {
        return sqlDurationMs;
    }
}

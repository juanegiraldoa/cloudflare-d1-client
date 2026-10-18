package dev.juanes.response.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timings {
    @JsonProperty("sql_duration_ms")
    private Long sqlDurationMs;

    @JsonProperty("sql_duration_ms")
    public Long getSqlDurationMs() {
        return sqlDurationMs;
    }

    @JsonProperty("sql_duration_ms")
    public void setSqlDurationMs(Long sqlDurationMs) {
        this.sqlDurationMs = sqlDurationMs;
    }
}

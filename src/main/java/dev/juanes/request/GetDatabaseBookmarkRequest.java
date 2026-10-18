package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetDatabaseBookmarkRequest {
    @JsonIgnore
    private String databaseId;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonIgnore
    public String getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(String databaseId) {
        this.databaseId = databaseId;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String query() {
        if (timestamp == null || timestamp.isBlank()) {
            return "";
        }
        return "timestamp=" + URLEncoder.encode(timestamp, StandardCharsets.UTF_8);
    }

    private GetDatabaseBookmarkRequest(Builder builder) {
        this.databaseId = builder.databaseId;
        this.timestamp = builder.timestamp;
    }

    public static class Builder {
        private String databaseId;
        private String timestamp;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

        public Builder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Convenience overload that converts epoch milliseconds to an ISO-8601 timestamp.
         */
        public Builder withTimestamp(Long timestamp) {
            this.timestamp = timestamp == null ? null : java.time.Instant.ofEpochMilli(timestamp).toString();
            return this;
        }

        public GetDatabaseBookmarkRequest build() {
            return new GetDatabaseBookmarkRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

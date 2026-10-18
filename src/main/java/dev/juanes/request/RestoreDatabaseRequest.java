package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestoreDatabaseRequest {
    @JsonIgnore
    private final String databaseId;

    private final String bookmark;

    private final String timestamp;

    @JsonIgnore
    public String getDatabaseId() {
        return databaseId;
    }

    public String getBookmark() {
        return bookmark;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String query() {
        List<String> params = new ArrayList<>();
        if (bookmark != null && !bookmark.isBlank()) {
            params.add("bookmark=" + URLEncoder.encode(bookmark, StandardCharsets.UTF_8));
        }
        if (timestamp != null && !timestamp.isBlank()) {
            params.add("timestamp=" + URLEncoder.encode(timestamp, StandardCharsets.UTF_8));
        }
        return String.join("&", params);
    }

    private RestoreDatabaseRequest(Builder builder) {
        this.databaseId = builder.databaseId;
        this.bookmark = builder.bookmark;
        this.timestamp = builder.timestamp;
    }

    public static class Builder {
        private String databaseId;
        private String bookmark;
        private String timestamp;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

        public Builder withBookmark(String bookmark) {
            this.bookmark = bookmark;
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

        public RestoreDatabaseRequest build() {
            return new RestoreDatabaseRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

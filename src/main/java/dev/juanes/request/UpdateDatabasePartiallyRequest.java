package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.commons.ReadReplication;

public class UpdateDatabasePartiallyRequest {
    @JsonProperty("read_replication")
    private final ReadReplication readReplication;
    private final String databaseId;

    public ReadReplication getReadReplication() {
        return readReplication;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    UpdateDatabasePartiallyRequest(Builder builder) {
        this.readReplication = builder.readReplication;
        this.databaseId = builder.databaseId;
    }

    public static class Builder {
        private ReadReplication readReplication;
        private String databaseId;

        public Builder withReadReplication(ReadReplication readReplication) {
            this.readReplication = readReplication;
            return this;
        }

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

        public UpdateDatabasePartiallyRequest build() {
            return new UpdateDatabasePartiallyRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

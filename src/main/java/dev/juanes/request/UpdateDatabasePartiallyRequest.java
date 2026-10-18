package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.commons.ReadReplication;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateDatabasePartiallyRequest {
    @JsonIgnore
    private final String databaseId;

    @JsonProperty("read_replication")
    private final ReadReplication readReplication;

    @JsonIgnore
    public String getDatabaseId() {
        return databaseId;
    }

    @JsonProperty("read_replication")
    public ReadReplication getReadReplication() {
        return readReplication;
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

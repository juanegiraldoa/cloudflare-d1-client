package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.juanes.commons.ReadReplication;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateDatabaseRequest {
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

    private UpdateDatabaseRequest(Builder builder) {
        this.databaseId = builder.databaseId;
        this.readReplication = builder.readReplication;
    }

    public static class Builder {
        private String databaseId;
        private ReadReplication readReplication;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

        public Builder withReadReplication(ReadReplication readReplication) {
            this.readReplication = readReplication;
            return this;
        }

        public UpdateDatabaseRequest build() {
            return new UpdateDatabaseRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

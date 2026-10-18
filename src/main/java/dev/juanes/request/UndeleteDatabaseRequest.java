package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UndeleteDatabaseRequest {
    @JsonIgnore
    private final String databaseId;

    @JsonProperty("new_name")
    private final String newName;

    @JsonIgnore
    public String getDatabaseId() {
        return databaseId;
    }

    @JsonProperty("new_name")
    public String getNewName() {
        return newName;
    }

    private UndeleteDatabaseRequest(Builder builder) {
        this.databaseId = builder.databaseId;
        this.newName = builder.newName;
    }

    public static class Builder {
        private String databaseId;
        private String newName;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

        public Builder withNewName(String newName) {
            this.newName = newName;
            return this;
        }

        public UndeleteDatabaseRequest build() {
            return new UndeleteDatabaseRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

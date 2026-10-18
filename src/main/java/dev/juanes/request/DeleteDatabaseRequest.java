package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DeleteDatabaseRequest {
    private final String databaseId;

    @JsonIgnore
    public String getDatabaseId() {
        return databaseId;
    }

    private DeleteDatabaseRequest(Builder builder) {
        this.databaseId = builder.databaseId;
    }

    public static class Builder {
        private String databaseId;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

        public DeleteDatabaseRequest build() {
            return new DeleteDatabaseRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

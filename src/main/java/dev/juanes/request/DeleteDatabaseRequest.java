package dev.juanes.request;

public class DeleteDatabaseRequest {
    private final String databaseId;

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

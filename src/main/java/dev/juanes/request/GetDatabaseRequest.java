package dev.juanes.request;

public class GetDatabaseRequest {
    private final String databaseId;

    public String getDatabaseId() {
        return databaseId;
    }

    private GetDatabaseRequest(Builder builder) {
        this.databaseId = builder.databaseId;
    }

    public static class Builder {
        private String databaseId;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

        public GetDatabaseRequest build() {
            return new GetDatabaseRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

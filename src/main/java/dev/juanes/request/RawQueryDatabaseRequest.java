package dev.juanes.request;

import java.util.List;

public class RawQueryDatabaseRequest {
    private final List<String> params;
    private final String sql;

    public List<String> getParams() {
        return params;
    }

    public String getSql() {
        return sql;
    }

    RawQueryDatabaseRequest(Builder builder) {
        this.params = builder.params;
        this.sql = builder.sql;
    }

    public static class Builder {
        private List<String> params;
        private String sql;

        public Builder withParams(List<String> params) {
            this.params = params;
            return this;
        }

        public Builder withSql(String sql) {
            this.sql = sql;
            return this;
        }

        public RawQueryDatabaseRequest build() {
            return new RawQueryDatabaseRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

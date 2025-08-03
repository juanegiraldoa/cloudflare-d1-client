package dev.juanes.request;

import java.util.List;

public class QueryDatabaseRequest {
    private final List<String> params;
    private final String sql;

    public List<String> getParams() {
        return params;
    }

    public String getSql() {
        return sql;
    }

    public QueryDatabaseRequest(Builder builder) {
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

        public QueryDatabaseRequest build() {
            return new QueryDatabaseRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

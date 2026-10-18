package dev.juanes.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import dev.juanes.request.commons.Query;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryDatabaseRequest {
    @JsonIgnore
    private final String databaseId;

    private final List<Object> params;
    private final String sql;
    private final List<Query> batch;

    @JsonIgnore
    public String getDatabaseId() {
        return databaseId;
    }

    public List<Object> getParams() {
        return params;
    }

    public String getSql() {
        return sql;
    }

    public List<Query> getBatch() {
        return batch;
    }

    public QueryDatabaseRequest(Builder builder) {
        this.databaseId = builder.databaseId;
        this.params = builder.params;
        this.sql = builder.sql;
        this.batch = builder.batch;
    }

    public static class Builder {
        private String databaseId;
        private List<Object> params;
        private String sql;
        private List<Query> batch;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

        public Builder withParams(List<?> params) {
            this.params = params == null ? null : new ArrayList<>(params);
            return this;
        }

        public Builder withSql(String sql) {
            this.sql = sql;
            return this;
        }

        public Builder withBatch(List<Query> batch) {
            this.batch = batch == null ? null : new ArrayList<>(batch);
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

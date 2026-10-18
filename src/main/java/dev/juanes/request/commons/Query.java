package dev.juanes.request.commons;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * A single statement inside a batch query.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Query {
    private final String sql;
    private final List<Object> params;

    public String getSql() {
        return sql;
    }

    public List<Object> getParams() {
        return params;
    }

    private Query(Builder builder) {
        this.sql = builder.sql;
        this.params = builder.params;
    }

    public static class Builder {
        private String sql;
        private List<Object> params;

        public Builder withSql(String sql) {
            this.sql = sql;
            return this;
        }

        public Builder withParams(List<?> params) {
            this.params = params == null ? null : new ArrayList<>(params);
            return this;
        }

        public Query build() {
            return new Query(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

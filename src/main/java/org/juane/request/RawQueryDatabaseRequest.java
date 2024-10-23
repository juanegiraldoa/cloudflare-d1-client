package org.juane.request;

import java.util.List;

public class RawQueryDatabaseRequest {
    private List<String> params;
    private String sql;

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
